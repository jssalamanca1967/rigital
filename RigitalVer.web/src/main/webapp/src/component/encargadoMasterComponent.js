define(['controller/selectionController', 'model/cacheModel', 'model/encargadoMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/encargadoComponent',
 'component/wikiComponent'
 ,
 'component/maquinaVirtualComponent'
 ,
 'component/paginaWebComponent'
 ,
 'component/unidadDeRedComponent'
 ,
 'component/repositorioComponent'
 ,
 'component/contenedorWebComponent'
 ,
 'component/softwareSalasComponent'
 ,
 'component/sQLDevComponent'
 ,
 'component/mySQLComponent'
 
 ],function(SelectionController, CacheModel, EncargadoMasterModel, CRUDComponent, TabController, EncargadoComponent,
 wikiComponent
 ,
 maquinaVirtualComponent
 ,
 paginaWebComponent
 ,
 unidadDeRedComponent
 ,
 repositorioComponent
 ,
 contenedorWebComponent
 ,
 softwareSalasComponent
 ,
 sQLDevComponent
 ,
 mySQLComponent
 ) {
    App.Component.EncargadoMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('encargadoMaster');
            var uComponent = new EncargadoComponent();
            uComponent.initialize();
            uComponent.render('main');
            Backbone.on(uComponent.componentId + '-post-encargado-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-post-encargado-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-pre-encargado-list', function() {
                self.hideChilds();
            });
            Backbone.on('encargado-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'encargado-master-save', view: self, message: error});
            });
            Backbone.on(uComponent.componentId + '-instead-encargado-save', function(params) {
                self.model.set('encargadoEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }
                var wikiModels = self.wikiComponent.componentController.wikiModelList;
                self.model.set('listwiki', []);
                self.model.set('createwiki', []);
                self.model.set('updatewiki', []);
                self.model.set('deletewiki', []);
                for (var i = 0; i < wikiModels.models.length; i++) {
                    var m =wikiModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createwiki').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatewiki').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < wikiModels.deletedModels.length; i++) {
                    var m = wikiModels.deletedModels[i];
                    self.model.get('deletewiki').push(m.toJSON());
                }
                var maquinaVirtualModels = self.maquinaVirtualComponent.componentController.maquinaVirtualModelList;
                self.model.set('listmaquinaVirtual', []);
                self.model.set('createmaquinaVirtual', []);
                self.model.set('updatemaquinaVirtual', []);
                self.model.set('deletemaquinaVirtual', []);
                for (var i = 0; i < maquinaVirtualModels.models.length; i++) {
                    var m =maquinaVirtualModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createmaquinaVirtual').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatemaquinaVirtual').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < maquinaVirtualModels.deletedModels.length; i++) {
                    var m = maquinaVirtualModels.deletedModels[i];
                    self.model.get('deletemaquinaVirtual').push(m.toJSON());
                }
                var paginaWebModels = self.paginaWebComponent.componentController.paginaWebModelList;
                self.model.set('listpaginaWeb', []);
                self.model.set('createpaginaWeb', []);
                self.model.set('updatepaginaWeb', []);
                self.model.set('deletepaginaWeb', []);
                for (var i = 0; i < paginaWebModels.models.length; i++) {
                    var m =paginaWebModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createpaginaWeb').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatepaginaWeb').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < paginaWebModels.deletedModels.length; i++) {
                    var m = paginaWebModels.deletedModels[i];
                    self.model.get('deletepaginaWeb').push(m.toJSON());
                }
                var unidadDeRedModels = self.unidadDeRedComponent.componentController.unidadDeRedModelList;
                self.model.set('listunidadDeRed', []);
                self.model.set('createunidadDeRed', []);
                self.model.set('updateunidadDeRed', []);
                self.model.set('deleteunidadDeRed', []);
                for (var i = 0; i < unidadDeRedModels.models.length; i++) {
                    var m =unidadDeRedModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createunidadDeRed').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateunidadDeRed').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < unidadDeRedModels.deletedModels.length; i++) {
                    var m = unidadDeRedModels.deletedModels[i];
                    self.model.get('deleteunidadDeRed').push(m.toJSON());
                }
                var repositorioModels = self.repositorioComponent.componentController.repositorioModelList;
                self.model.set('listrepositorio', []);
                self.model.set('createrepositorio', []);
                self.model.set('updaterepositorio', []);
                self.model.set('deleterepositorio', []);
                for (var i = 0; i < repositorioModels.models.length; i++) {
                    var m =repositorioModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createrepositorio').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updaterepositorio').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < repositorioModels.deletedModels.length; i++) {
                    var m = repositorioModels.deletedModels[i];
                    self.model.get('deleterepositorio').push(m.toJSON());
                }
                var contenedorWebModels = self.contenedorWebComponent.componentController.contenedorWebModelList;
                self.model.set('listcontenedorWeb', []);
                self.model.set('createcontenedorWeb', []);
                self.model.set('updatecontenedorWeb', []);
                self.model.set('deletecontenedorWeb', []);
                for (var i = 0; i < contenedorWebModels.models.length; i++) {
                    var m =contenedorWebModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createcontenedorWeb').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatecontenedorWeb').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < contenedorWebModels.deletedModels.length; i++) {
                    var m = contenedorWebModels.deletedModels[i];
                    self.model.get('deletecontenedorWeb').push(m.toJSON());
                }
                var softwareSalasModels = self.softwareSalasComponent.componentController.softwareSalasModelList;
                self.model.set('listsoftwareSalas', []);
                self.model.set('createsoftwareSalas', []);
                self.model.set('updatesoftwareSalas', []);
                self.model.set('deletesoftwareSalas', []);
                for (var i = 0; i < softwareSalasModels.models.length; i++) {
                    var m =softwareSalasModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createsoftwareSalas').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatesoftwareSalas').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < softwareSalasModels.deletedModels.length; i++) {
                    var m = softwareSalasModels.deletedModels[i];
                    self.model.get('deletesoftwareSalas').push(m.toJSON());
                }
                var sQLDevModels = self.sQLDevComponent.componentController.sQLDevModelList;
                self.model.set('listsQLDev', []);
                self.model.set('createsQLDev', []);
                self.model.set('updatesQLDev', []);
                self.model.set('deletesQLDev', []);
                for (var i = 0; i < sQLDevModels.models.length; i++) {
                    var m =sQLDevModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createsQLDev').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatesQLDev').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < sQLDevModels.deletedModels.length; i++) {
                    var m = sQLDevModels.deletedModels[i];
                    self.model.get('deletesQLDev').push(m.toJSON());
                }
                var mySQLModels = self.mySQLComponent.componentController.mySQLModelList;
                self.model.set('listmySQL', []);
                self.model.set('createmySQL', []);
                self.model.set('updatemySQL', []);
                self.model.set('deletemySQL', []);
                for (var i = 0; i < mySQLModels.models.length; i++) {
                    var m =mySQLModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createmySQL').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updatemySQL').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < mySQLModels.deletedModels.length; i++) {
                    var m = mySQLModels.deletedModels[i];
                    self.model.get('deletemySQL').push(m.toJSON());
                }
                self.model.save({}, {
                    success: function() {
                        Backbone.trigger(uComponent.componentId + '-post-encargado-save', self);
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'encargado-master-save', view: self, error: error});
                    }
                });
            });
        },
        renderChilds: function(params) {
            var self = this;
            this.tabModel = new App.Model.TabModel(
                    {
                        tabs: [
                            {label: "Wiki", name: "wiki", enable: true},
                            ,
                            {label: "Maquina Virtual", name: "maquinaVirtual", enable: true},
                            ,
                            {label: "Pagina Web", name: "paginaWeb", enable: true},
                            ,
                            {label: "Unidad De Red", name: "unidadDeRed", enable: true},
                            ,
                            {label: "Repositorio", name: "repositorio", enable: true},
                            ,
                            {label: "Contenedor Web", name: "contenedorWeb", enable: true},
                            ,
                            {label: "Software Salas", name: "softwareSalas", enable: true},
                            ,
                            {label: "S Q L Dev", name: "sQLDev", enable: true},
                            ,
                            {label: "My S Q L", name: "mySQL", enable: true},
                        ]
                    }
            );

            this.tabs = new TabController({model: this.tabModel});

            this.tabs.render('tabs');
            App.Model.EncargadoMasterModel.prototype.urlRoot = this.configuration.context;
            var options = {
                success: function() {
					self.wikiComponent = new wikiComponent();
                    self.wikiModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.WikiModel), self.model.get('listwiki'));
                    self.wikiComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.WikiModel),
                        listModelClass: App.Utils.createCacheList(App.Model.WikiModel, App.Model.WikiList, self.wikiModels)
                    });
                    self.wikiComponent.render(self.tabs.getTabHtmlId('wiki'));
                    Backbone.on(self.wikiComponent.componentId + '-post-wiki-create', function(params) {
                        params.view.currentWikiModel.setCacheList(params.view.wikiModelList);
                    });
					self.maquinaVirtualComponent = new maquinaVirtualComponent();
                    self.maquinaVirtualModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.MaquinaVirtualModel), self.model.get('listmaquinaVirtual'));
                    self.maquinaVirtualComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.MaquinaVirtualModel),
                        listModelClass: App.Utils.createCacheList(App.Model.MaquinaVirtualModel, App.Model.MaquinaVirtualList, self.maquinaVirtualModels)
                    });
                    self.maquinaVirtualComponent.render(self.tabs.getTabHtmlId('maquinaVirtual'));
                    Backbone.on(self.maquinaVirtualComponent.componentId + '-post-maquinaVirtual-create', function(params) {
                        params.view.currentMaquinaVirtualModel.setCacheList(params.view.maquinaVirtualModelList);
                    });
					self.paginaWebComponent = new paginaWebComponent();
                    self.paginaWebModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.PaginaWebModel), self.model.get('listpaginaWeb'));
                    self.paginaWebComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.PaginaWebModel),
                        listModelClass: App.Utils.createCacheList(App.Model.PaginaWebModel, App.Model.PaginaWebList, self.paginaWebModels)
                    });
                    self.paginaWebComponent.render(self.tabs.getTabHtmlId('paginaWeb'));
                    Backbone.on(self.paginaWebComponent.componentId + '-post-paginaWeb-create', function(params) {
                        params.view.currentPaginaWebModel.setCacheList(params.view.paginaWebModelList);
                    });
					self.unidadDeRedComponent = new unidadDeRedComponent();
                    self.unidadDeRedModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.UnidadDeRedModel), self.model.get('listunidadDeRed'));
                    self.unidadDeRedComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.UnidadDeRedModel),
                        listModelClass: App.Utils.createCacheList(App.Model.UnidadDeRedModel, App.Model.UnidadDeRedList, self.unidadDeRedModels)
                    });
                    self.unidadDeRedComponent.render(self.tabs.getTabHtmlId('unidadDeRed'));
                    Backbone.on(self.unidadDeRedComponent.componentId + '-post-unidadDeRed-create', function(params) {
                        params.view.currentUnidadDeRedModel.setCacheList(params.view.unidadDeRedModelList);
                    });
					self.repositorioComponent = new repositorioComponent();
                    self.repositorioModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.RepositorioModel), self.model.get('listrepositorio'));
                    self.repositorioComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.RepositorioModel),
                        listModelClass: App.Utils.createCacheList(App.Model.RepositorioModel, App.Model.RepositorioList, self.repositorioModels)
                    });
                    self.repositorioComponent.render(self.tabs.getTabHtmlId('repositorio'));
                    Backbone.on(self.repositorioComponent.componentId + '-post-repositorio-create', function(params) {
                        params.view.currentRepositorioModel.setCacheList(params.view.repositorioModelList);
                    });
					self.contenedorWebComponent = new contenedorWebComponent();
                    self.contenedorWebModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.ContenedorWebModel), self.model.get('listcontenedorWeb'));
                    self.contenedorWebComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.ContenedorWebModel),
                        listModelClass: App.Utils.createCacheList(App.Model.ContenedorWebModel, App.Model.ContenedorWebList, self.contenedorWebModels)
                    });
                    self.contenedorWebComponent.render(self.tabs.getTabHtmlId('contenedorWeb'));
                    Backbone.on(self.contenedorWebComponent.componentId + '-post-contenedorWeb-create', function(params) {
                        params.view.currentContenedorWebModel.setCacheList(params.view.contenedorWebModelList);
                    });
					self.softwareSalasComponent = new softwareSalasComponent();
                    self.softwareSalasModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.SoftwareSalasModel), self.model.get('listsoftwareSalas'));
                    self.softwareSalasComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.SoftwareSalasModel),
                        listModelClass: App.Utils.createCacheList(App.Model.SoftwareSalasModel, App.Model.SoftwareSalasList, self.softwareSalasModels)
                    });
                    self.softwareSalasComponent.render(self.tabs.getTabHtmlId('softwareSalas'));
                    Backbone.on(self.softwareSalasComponent.componentId + '-post-softwareSalas-create', function(params) {
                        params.view.currentSoftwareSalasModel.setCacheList(params.view.softwareSalasModelList);
                    });
					self.sQLDevComponent = new sQLDevComponent();
                    self.sQLDevModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.SQLDevModel), self.model.get('listsQLDev'));
                    self.sQLDevComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.SQLDevModel),
                        listModelClass: App.Utils.createCacheList(App.Model.SQLDevModel, App.Model.SQLDevList, self.sQLDevModels)
                    });
                    self.sQLDevComponent.render(self.tabs.getTabHtmlId('sQLDev'));
                    Backbone.on(self.sQLDevComponent.componentId + '-post-sQLDev-create', function(params) {
                        params.view.currentSQLDevModel.setCacheList(params.view.sQLDevModelList);
                    });
					self.mySQLComponent = new mySQLComponent();
                    self.mySQLModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.MySQLModel), self.model.get('listmySQL'));
                    self.mySQLComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.MySQLModel),
                        listModelClass: App.Utils.createCacheList(App.Model.MySQLModel, App.Model.MySQLList, self.mySQLModels)
                    });
                    self.mySQLComponent.render(self.tabs.getTabHtmlId('mySQL'));
                    Backbone.on(self.mySQLComponent.componentId + '-post-mySQL-create', function(params) {
                        params.view.currentMySQLModel.setCacheList(params.view.mySQLModelList);
                    });
                    self.wikiToolbarModel = self.wikiComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.wikiComponent.setToolbarModel(self.wikiToolbarModel);
                    self.maquinaVirtualToolbarModel = self.maquinaVirtualComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.maquinaVirtualComponent.setToolbarModel(self.maquinaVirtualToolbarModel);
                    self.paginaWebToolbarModel = self.paginaWebComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.paginaWebComponent.setToolbarModel(self.paginaWebToolbarModel);
                    self.unidadDeRedToolbarModel = self.unidadDeRedComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.unidadDeRedComponent.setToolbarModel(self.unidadDeRedToolbarModel);
                    self.repositorioToolbarModel = self.repositorioComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.repositorioComponent.setToolbarModel(self.repositorioToolbarModel);
                    self.contenedorWebToolbarModel = self.contenedorWebComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.contenedorWebComponent.setToolbarModel(self.contenedorWebToolbarModel);
                    self.softwareSalasToolbarModel = self.softwareSalasComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.softwareSalasComponent.setToolbarModel(self.softwareSalasToolbarModel);
                    self.sQLDevToolbarModel = self.sQLDevComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.sQLDevComponent.setToolbarModel(self.sQLDevToolbarModel);
                    self.mySQLToolbarModel = self.mySQLComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.mySQLComponent.setToolbarModel(self.mySQLToolbarModel);
                	
                     
                
                    Backbone.on(self.wikiComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"wikiComponent"});
                        App.Utils.getComponentList('wikiComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no Wikis to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Wiki List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('wikiComponent-post-selection', function(models) {
                        var cachewikiModel = App.Utils.createCacheModel(App.Model.WikiModel);
                        models = App.Utils.convertToModel(cachewikiModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.wikiComponent.componentController.wikiModelList);
                        	model.save('',{});
                        }
                        self.wikiComponent.componentController.showEdit=false;
                        self.wikiComponent.componentController.list();
                        
                    });
                    Backbone.on(self.maquinaVirtualComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"maquinaVirtualComponent"});
                        App.Utils.getComponentList('maquinaVirtualComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no Maquina Virtuals to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Maquina Virtual List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('maquinaVirtualComponent-post-selection', function(models) {
                        var cachemaquinaVirtualModel = App.Utils.createCacheModel(App.Model.MaquinaVirtualModel);
                        models = App.Utils.convertToModel(cachemaquinaVirtualModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.maquinaVirtualComponent.componentController.maquinaVirtualModelList);
                        	model.save('',{});
                        }
                        self.maquinaVirtualComponent.componentController.showEdit=false;
                        self.maquinaVirtualComponent.componentController.list();
                        
                    });
                    Backbone.on(self.paginaWebComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"paginaWebComponent"});
                        App.Utils.getComponentList('paginaWebComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no Pagina Webs to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Pagina Web List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('paginaWebComponent-post-selection', function(models) {
                        var cachepaginaWebModel = App.Utils.createCacheModel(App.Model.PaginaWebModel);
                        models = App.Utils.convertToModel(cachepaginaWebModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.paginaWebComponent.componentController.paginaWebModelList);
                        	model.save('',{});
                        }
                        self.paginaWebComponent.componentController.showEdit=false;
                        self.paginaWebComponent.componentController.list();
                        
                    });
                    Backbone.on(self.unidadDeRedComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"unidadDeRedComponent"});
                        App.Utils.getComponentList('unidadDeRedComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no Unidad De Reds to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Unidad De Red List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('unidadDeRedComponent-post-selection', function(models) {
                        var cacheunidadDeRedModel = App.Utils.createCacheModel(App.Model.UnidadDeRedModel);
                        models = App.Utils.convertToModel(cacheunidadDeRedModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.unidadDeRedComponent.componentController.unidadDeRedModelList);
                        	model.save('',{});
                        }
                        self.unidadDeRedComponent.componentController.showEdit=false;
                        self.unidadDeRedComponent.componentController.list();
                        
                    });
                    Backbone.on(self.repositorioComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"repositorioComponent"});
                        App.Utils.getComponentList('repositorioComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no Repositorios to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Repositorio List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('repositorioComponent-post-selection', function(models) {
                        var cacherepositorioModel = App.Utils.createCacheModel(App.Model.RepositorioModel);
                        models = App.Utils.convertToModel(cacherepositorioModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.repositorioComponent.componentController.repositorioModelList);
                        	model.save('',{});
                        }
                        self.repositorioComponent.componentController.showEdit=false;
                        self.repositorioComponent.componentController.list();
                        
                    });
                    Backbone.on(self.contenedorWebComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"contenedorWebComponent"});
                        App.Utils.getComponentList('contenedorWebComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no Contenedor Webs to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Contenedor Web List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('contenedorWebComponent-post-selection', function(models) {
                        var cachecontenedorWebModel = App.Utils.createCacheModel(App.Model.ContenedorWebModel);
                        models = App.Utils.convertToModel(cachecontenedorWebModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.contenedorWebComponent.componentController.contenedorWebModelList);
                        	model.save('',{});
                        }
                        self.contenedorWebComponent.componentController.showEdit=false;
                        self.contenedorWebComponent.componentController.list();
                        
                    });
                    Backbone.on(self.softwareSalasComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"softwareSalasComponent"});
                        App.Utils.getComponentList('softwareSalasComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no Software Salass to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Software Salas List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('softwareSalasComponent-post-selection', function(models) {
                        var cachesoftwareSalasModel = App.Utils.createCacheModel(App.Model.SoftwareSalasModel);
                        models = App.Utils.convertToModel(cachesoftwareSalasModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.softwareSalasComponent.componentController.softwareSalasModelList);
                        	model.save('',{});
                        }
                        self.softwareSalasComponent.componentController.showEdit=false;
                        self.softwareSalasComponent.componentController.list();
                        
                    });
                    Backbone.on(self.sQLDevComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"sQLDevComponent"});
                        App.Utils.getComponentList('sQLDevComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no S Q L Devs to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'S Q L Dev List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('sQLDevComponent-post-selection', function(models) {
                        var cachesQLDevModel = App.Utils.createCacheModel(App.Model.SQLDevModel);
                        models = App.Utils.convertToModel(cachesQLDevModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.sQLDevComponent.componentController.sQLDevModelList);
                        	model.save('',{});
                        }
                        self.sQLDevComponent.componentController.showEdit=false;
                        self.sQLDevComponent.componentController.list();
                        
                    });
                    Backbone.on(self.mySQLComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController({"componentId":"mySQLComponent"});
                        App.Utils.getComponentList('mySQLComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no My S Q Ls to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'My S Q L List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('mySQLComponent-post-selection', function(models) {
                        var cachemySQLModel = App.Utils.createCacheModel(App.Model.MySQLModel);
                        models = App.Utils.convertToModel(cachemySQLModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.mySQLComponent.componentController.mySQLModelList);
                        	model.save('',{});
                        }
                        self.mySQLComponent.componentController.showEdit=false;
                        self.mySQLComponent.componentController.list();
                        
                    });
                    $('#tabs').show();
                },
                error: function() {
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'encargado-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.EncargadoMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.EncargadoMasterModel();
                options.success();
            }


        },
        hideChilds: function() {
            $('#tabs').hide();
        }
    });

    return App.Component.EncargadoMasterComponent;
});