/* ========================================================================
 * Copyright 2014 grupo
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 grupo

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/
define(['model/maquinaVirtualModel'], function(maquinaVirtualModel) {
    App.Controller._MaquinaVirtualController = Backbone.View.extend({
        initialize: function(options) {
            this.modelClass = options.modelClass;
            this.listModelClass = options.listModelClass;
            this.showEdit = true;
            this.showDelete = true;
            this.editTemplate = _.template($('#maquinaVirtual').html());
            this.listTemplate = _.template($('#maquinaVirtualList').html());
            if (!options || !options.componentId) {
                this.componentId = _.random(0, 100) + "";
            }else{
				this.componentId = options.componentId;
		    }
            var self = this;
            if(self.postInit){
            	self.postInit(options);
            }
        },
        create: function() {
            if (App.Utils.eventExists(this.componentId + '-' +'instead-maquinaVirtual-create')) {
                Backbone.trigger(this.componentId + '-' + 'instead-maquinaVirtual-create', {view: this});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-maquinaVirtual-create', {view: this});
                this.currentMaquinaVirtualModel = new this.modelClass({componentId: this.componentId});
                this._renderEdit();
                Backbone.trigger(this.componentId + '-' + 'post-maquinaVirtual-create', {view: this});
            }
        },
        list: function(params) {
            if (params) {
                var data = params.data;
            }
            if (App.Utils.eventExists(this.componentId + '-' +'instead-maquinaVirtual-list')) {
                Backbone.trigger(this.componentId + '-' + 'instead-maquinaVirtual-list', {view: this, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-maquinaVirtual-list', {view: this, data: data});
                var self = this;
				if(!this.maquinaVirtualModelList){
                 this.maquinaVirtualModelList = new this.listModelClass();
				}
                this.maquinaVirtualModelList.fetch({
                    data: data,
                    success: function() {
                        self._renderList();
                        Backbone.trigger(self.componentId + '-' + 'post-maquinaVirtual-list', {view: self});
                    },
                    error: function(mode, error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'maquinaVirtual-list', view: self, error: error});
                    }
                });
            }
        },
        edit: function(params) {
            var id = params.id;
            var data = params.data;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-maquinaVirtual-edit')) {
                Backbone.trigger(this.componentId + '-' + 'instead-maquinaVirtual-edit', {view: this, id: id, data: data});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-maquinaVirtual-edit', {view: this, id: id, data: data});
                if (this.maquinaVirtualModelList) {
                    this.currentMaquinaVirtualModel = this.maquinaVirtualModelList.get(id);
                    this.currentMaquinaVirtualModel.set('componentId',this.componentId); 
                    this._renderEdit();
                    Backbone.trigger(this.componentId + '-' + 'post-maquinaVirtual-edit', {view: this, id: id, data: data});
                } else {
                    var self = this;
                    this.currentMaquinaVirtualModel = new this.modelClass({id: id});
                    this.currentMaquinaVirtualModel.fetch({
                        data: data,
                        success: function() {
                            self.currentMaquinaVirtualModel.set('componentId',self.componentId); 
                            self._renderEdit();
                            Backbone.trigger(self.componentId + '-' + 'post-maquinaVirtual-edit', {view: this, id: id, data: data});
                        },
                        error: function() {
                            Backbone.trigger(self.componentId + '-' + 'error', {event: 'maquinaVirtual-edit', view: self, id: id, data: data, error: error});
                        }
                    });
                }
            }
        },
        destroy: function(params) {
            var id = params.id;
            var self = this;
            if (App.Utils.eventExists(this.componentId + '-' +'instead-maquinaVirtual-delete')) {
                Backbone.trigger(this.componentId + '-' + 'instead-maquinaVirtual-delete', {view: this, id: id});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-maquinaVirtual-delete', {view: this, id: id});
                var deleteModel;
                if (this.maquinaVirtualModelList) {
                    deleteModel = this.maquinaVirtualModelList.get(id);
                } else {
                    deleteModel = new this.modelClass({id: id});
                }
                deleteModel.destroy({
                    success: function() {
                        Backbone.trigger(self.componentId + '-' + 'post-maquinaVirtual-delete', {view: self, model: deleteModel});
                    },
                    error: function() {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'maquinaVirtual-delete', view: self, error: error});
                    }
                });
            }
        },
        save: function() {
            var self = this;
            var model = $('#' + this.componentId + '-maquinaVirtualForm').serializeObject();
 
			 if(!model.destruido){
			 	model.destruido=false
			 } 
            if (App.Utils.eventExists(this.componentId + '-' +'instead-maquinaVirtual-save')) {
                Backbone.trigger(this.componentId + '-' + 'instead-maquinaVirtual-save', {view: this, model : model});
            } else {
                Backbone.trigger(this.componentId + '-' + 'pre-maquinaVirtual-save', {view: this, model : model});
                this.currentMaquinaVirtualModel.set(model);
                this.currentMaquinaVirtualModel.save({},
                        {
                            success: function(model) {
                                Backbone.trigger(self.componentId + '-' + 'post-maquinaVirtual-save', {model: self.currentMaquinaVirtualModel});
                            },
                            error: function(error) {
                                Backbone.trigger(self.componentId + '-' + 'error', {event: 'maquinaVirtual-save', view: self, error: error});
                            }
                        });
            }
        },
        _renderList: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.listTemplate({maquinaVirtuals: self.maquinaVirtualModelList.models, componentId: self.componentId, showEdit : self.showEdit , showDelete : self.showDelete}));
                self.$el.slideDown("fast");
            });
        },
        _renderEdit: function() {
            var self = this;
            this.$el.slideUp("fast", function() {
                self.$el.html(self.editTemplate({maquinaVirtual: self.currentMaquinaVirtualModel, componentId: self.componentId , showEdit : self.showEdit , showDelete : self.showDelete
 
				}));
                self.$el.slideDown("fast");
            });
        }
    });
    return App.Controller._MaquinaVirtualController;
});