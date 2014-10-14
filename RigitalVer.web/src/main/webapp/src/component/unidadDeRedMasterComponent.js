define(['controller/selectionController', 'model/cacheModel', 'model/unidadDeRedMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/unidadDeRedComponent',
 'component/usuarioUnidadDeRedComponent'
 ,
 'component/problemaComponent'
 
 ],function(SelectionController, CacheModel, UnidadDeRedMasterModel, CRUDComponent, TabController, UnidadDeRedComponent,
 usuariosComponent
 ,
 problemasComponent
 ) {
    App.Component.UnidadDeRedMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('unidadDeRedMaster');
            var uComponent = new UnidadDeRedComponent();
            uComponent.initialize();
            uComponent.render('main');
            Backbone.on(uComponent.componentId + '-post-unidadDeRed-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-post-unidadDeRed-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-pre-unidadDeRed-list', function() {
                self.hideChilds();
            });
            Backbone.on('unidadDeRed-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'unidadDeRed-master-save', view: self, message: error});
            });
            Backbone.on(uComponent.componentId + '-instead-unidadDeRed-save', function(params) {
                self.model.set('unidadDeRedEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }
                var usuariosModels = self.usuariosComponent.componentController.usuarioUnidadDeRedModelList;
                self.model.set('listusuarios', []);
                self.model.set('createusuarios', []);
                self.model.set('updateusuarios', []);
                self.model.set('deleteusuarios', []);
                for (var i = 0; i < usuariosModels.models.length; i++) {
                    var m =usuariosModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createusuarios').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateusuarios').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < usuariosModels.deletedModels.length; i++) {
                    var m = usuariosModels.deletedModels[i];
                    self.model.get('deleteusuarios').push(m.toJSON());
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
                        Backbone.trigger(uComponent.componentId + '-post-unidadDeRed-save', self);
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'unidadDeRed-master-save', view: self, error: error});
                    }
                });
            });
        },
        renderChilds: function(params) {
            var self = this;
            this.tabModel = new App.Model.TabModel(
                    {
                        tabs: [
                            {label: "Usuarios", name: "usuarios", enable: true},
                            ,
                            {label: "Problemas", name: "problemas", enable: true},
                        ]
                    }
            );

            this.tabs = new TabController({model: this.tabModel});

            this.tabs.render('tabs');
            App.Model.UnidadDeRedMasterModel.prototype.urlRoot = this.configuration.context;
            var options = {
                success: function() {
					self.usuariosComponent = new usuariosComponent();
                    self.usuariosModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.UsuarioUnidadDeRedModel), self.model.get('listusuarios'));
                    self.usuariosComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.UsuarioUnidadDeRedModel),
                        listModelClass: App.Utils.createCacheList(App.Model.UsuarioUnidadDeRedModel, App.Model.UsuarioUnidadDeRedList, self.usuariosModels)
                    });
                    self.usuariosComponent.render(self.tabs.getTabHtmlId('usuarios'));
                    Backbone.on(self.usuariosComponent.componentId + '-post-usuarioUnidadDeRed-create', function(params) {
                        params.view.currentUsuarioUnidadDeRedModel.setCacheList(params.view.usuarioUnidadDeRedModelList);
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
                    self.usuariosToolbarModel = self.usuariosComponent.toolbarModel.set(App.Utils.Constans.referenceToolbarConfiguration);
                    self.usuariosComponent.setToolbarModel(self.usuariosToolbarModel);                    
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
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'unidadDeRed-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.UnidadDeRedMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.UnidadDeRedMasterModel();
                options.success();
            }


        },
        hideChilds: function() {
            $('#tabs').hide();
        }
    });

    return App.Component.UnidadDeRedMasterComponent;
});