define(['controller/selectionController', 'model/cacheModel', 'model/contenedorWebMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/contenedorWebComponent',
 'component/problemaComponent'
 
 ],function(SelectionController, CacheModel, ContenedorWebMasterModel, CRUDComponent, TabController, ContenedorWebComponent,
 problemaComponent
 ) {
    App.Component.ContenedorWebMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('contenedorWebMaster');
            var uComponent = new ContenedorWebComponent();
            uComponent.initialize();
            uComponent.render('main');
            Backbone.on(uComponent.componentId + '-post-contenedorWeb-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-post-contenedorWeb-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-pre-contenedorWeb-list', function() {
                self.hideChilds();
            });
            Backbone.on('contenedorWeb-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'contenedorWeb-master-save', view: self, message: error});
            });
            Backbone.on(uComponent.componentId + '-instead-contenedorWeb-save', function(params) {
                self.model.set('contenedorWebEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }
                var problemaModels = self.problemaComponent.componentController.problemaModelList;
                self.model.set('listproblema', []);
                self.model.set('createproblema', []);
                self.model.set('updateproblema', []);
                self.model.set('deleteproblema', []);
                for (var i = 0; i < problemaModels.models.length; i++) {
                    var m =problemaModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createproblema').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateproblema').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < problemaModels.deletedModels.length; i++) {
                    var m = problemaModels.deletedModels[i];
                    self.model.get('deleteproblema').push(m.toJSON());
                }
                self.model.save({}, {
                    success: function() {
                        Backbone.trigger(uComponent.componentId + '-post-contenedorWeb-save', self);
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'contenedorWeb-master-save', view: self, error: error});
                    }
                });
            });
        },
        renderChilds: function(params) {
            var self = this;
            this.tabModel = new App.Model.TabModel(
                    {
                        tabs: [
                            {label: "Problema", name: "problema", enable: true},
                        ]
                    }
            );

            this.tabs = new TabController({model: this.tabModel});

            this.tabs.render('tabs');
            App.Model.ContenedorWebMasterModel.prototype.urlRoot = this.configuration.context;
            var options = {
                success: function() {
					self.problemaComponent = new problemaComponent();
                    self.problemaModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.ProblemaModel), self.model.get('listproblema'));
                    self.problemaComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.ProblemaModel),
                        listModelClass: App.Utils.createCacheList(App.Model.ProblemaModel, App.Model.ProblemaList, self.problemaModels)
                    });
                    self.problemaComponent.render(self.tabs.getTabHtmlId('problema'));
                    Backbone.on(self.problemaComponent.componentId + '-post-problema-create', function(params) {
                        params.view.currentProblemaModel.setCacheList(params.view.problemaModelList);
                    });
                    self.problemaToolbarModel = self.problemaComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.problemaComponent.setToolbarModel(self.problemaToolbarModel);
                	
                     
                
                    Backbone.on(self.problemaComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"problemaComponent"});
                        App.Utils.getComponentList('problemaComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no Problemas to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Problema List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('problemaComponent-post-selection', function(models) {
                        var cacheproblemaModel = App.Utils.createCacheModel(App.Model.ProblemaModel);
                        models = App.Utils.convertToModel(cacheproblemaModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.problemaComponent.componentController.problemaModelList);
                        	model.save('',{});
                        }
                        self.problemaComponent.componentController.showEdit=false;
                        self.problemaComponent.componentController.list();
                        
                    });
                    $('#tabs').show();
                },
                error: function() {
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'contenedorWeb-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.ContenedorWebMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.ContenedorWebMasterModel();
                options.success();
            }


        },
        hideChilds: function() {
            $('#tabs').hide();
        }
    });

    return App.Component.ContenedorWebMasterComponent;
});