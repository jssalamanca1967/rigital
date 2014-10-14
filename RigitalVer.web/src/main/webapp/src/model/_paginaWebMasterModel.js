define([], function() {
    App.Model._PaginaWebMasterModel = Backbone.Model.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('paginaWeb-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.PaginaWebModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.paginaWebEntity,options);
            }
        }
    });

    App.Model._PaginaWebMasterList = Backbone.Collection.extend({
        model: App.Model._PaginaWebMasterModel,
        initialize: function() {
        }

    });
    return App.Model._PaginaWebMasterModel;
    
});