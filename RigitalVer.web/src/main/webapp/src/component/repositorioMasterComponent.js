define(['controller/selectionController', 'model/cacheModel', 'model/repositorioMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/repositorioComponent',
 'component/usuarioExternoRepoComponent'
 ,
 'component/problemaComponent'
 
 ],function(SelectionController, CacheModel, RepositorioMasterModel, CRUDComponent, TabController, RepositorioComponent,
 usuariosQueAccedenComponent
 ,
 problemasComponent
 ) {
    App.Component.RepositorioMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('repositorioMaster');
            var uComponent = new RepositorioComponent();
            uComponent.initialize();
            uComponent.render('main');
            Backbone.on(uComponent.componentId + '-post-repositorio-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-post-repositorio-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-pre-repositorio-list', function() {
                self.hideChilds();
            });
            Backbone.on('repositorio-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'repositorio-master-save', view: self, message: error});
            });
            Backbone.on(uComponent.componentId + '-instead-repositorio-save', function(params) {
                self.model.set('repositorioEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }
                var usuariosQueAccedenModels = self.usuariosQueAccedenComponent.componentController.usuarioExternoRepoModelList;
                self.model.set('listusuariosQueAcceden', []);
                self.model.set('createusuariosQueAcceden', []);
                self.model.set('updateusuariosQueAcceden', []);
                self.model.set('deleteusuariosQueAcceden', []);
                for (var i = 0; i < usuariosQueAccedenModels.models.length; i++) {
                    var m =usuariosQueAccedenModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createusuariosQueAcceden').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateusuariosQueAcceden').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < usuariosQueAccedenModels.deletedModels.length; i++) {
                    var m = usuariosQueAccedenModels.deletedModels[i];
                    self.model.get('deleteusuariosQueAcceden').push(m.toJSON());
                }
                var problemasModels = self.problemasComponent.componentController.problemaModelList;
                self.model.set('listproblemas', []);
                self.model.set('createproblemas', []);
                self.model.set('updateproblemas', []);
                self.model.set('deleteproblemas', []);
                for (var i = 0; i < problemasModels.models.length; i++) {
                    var m =problemasModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createproblemas').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateproblemas').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < problemasModels.deletedModels.length; i++) {
                    var m = problemasModels.deletedModels[i];
                    self.model.get('deleteproblemas').push(m.toJSON());
                }
                self.model.save({}, {
                    success: function() {
                        Backbone.trigger(uComponent.componentId + '-post-repositorio-save', self);
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'repositorio-master-save', view: self, error: error});
                    }
                });
            });
        },
        renderChilds: function(params) {
            var self = this;
            this.tabModel = new App.Model.TabModel(
                    {
                        tabs: [
                            {label: "Usuarios Que Acceden", name: "usuariosQueAcceden", enable: true},
                            ,
                            {label: "Problemas", name: "problemas", enable: true},
                        ]
                    }
            );

            this.tabs = new TabController({model: this.tabModel});

            this.tabs.render('tabs');
            App.Model.RepositorioMasterModel.prototype.urlRoot = this.configuration.context;
            var options = {
                success: function() {
					self.usuariosQueAccedenComponent = new usuariosQueAccedenComponent();
                    self.usuariosQueAccedenModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.UsuarioExternoRepoModel), self.model.get('listusuariosQueAcceden'));
                    self.usuariosQueAccedenComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.UsuarioExternoRepoModel),
                        listModelClass: App.Utils.createCacheList(App.Model.UsuarioExternoRepoModel, App.Model.UsuarioExternoRepoList, self.usuariosQueAccedenModels)
                    });
                    self.usuariosQueAccedenComponent.render(self.tabs.getTabHtmlId('usuariosQueAcceden'));
                    Backbone.on(self.usuariosQueAccedenComponent.componentId + '-post-usuarioExternoRepo-create', function(params) {
                        params.view.currentUsuarioExternoRepoModel.setCacheList(params.view.usuarioExternoRepoModelList);
                    });
					self.problemasComponent = new problemasComponent();
                    self.problemasModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.ProblemaModel), self.model.get('listproblemas'));
                    self.problemasComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.ProblemaModel),
                        listModelClass: App.Utils.createCacheList(App.Model.ProblemaModel, App.Model.ProblemaList, self.problemasModels)
                    });
                    self.problemasComponent.render(self.tabs.getTabHtmlId('problemas'));
                    Backbone.on(self.problemasComponent.componentId + '-post-problema-create', function(params) {
                        params.view.currentProblemaModel.setCacheList(params.view.problemaModelList);
                    });
                    self.usuariosQueAccedenToolbarModel = self.usuariosQueAccedenComponent.toolbarModel.set(App.Utils.Constans.referenceToolbarConfiguration);
                    self.usuariosQueAccedenComponent.setToolbarModel(self.usuariosQueAccedenToolbarModel);                    
                    self.problemasToolbarModel = self.problemasComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.problemasComponent.setToolbarModel(self.problemasToolbarModel);
                	
                     
                
                    Backbone.on(self.problemasComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"problemasComponent"});
                        App.Utils.getComponentList('problemaComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no Problemass to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Problemas List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('problemasComponent-post-selection', function(models) {
                        var cacheproblemasModel = App.Utils.createCacheModel(App.Model.ProblemaModel);
                        models = App.Utils.convertToModel(cacheproblemasModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.problemasComponent.componentController.problemaModelList);
                        	model.save('',{});
                        }
                        self.problemasComponent.componentController.showEdit=false;
                        self.problemasComponent.componentController.list();
                        
                    });
                    $('#tabs').show();
                },
                error: function() {
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'repositorio-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.RepositorioMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.RepositorioMasterModel();
                options.success();
            }


        },
        hideChilds: function() {
            $('#tabs').hide();
        }
    });

    return App.Component.RepositorioMasterComponent;
});