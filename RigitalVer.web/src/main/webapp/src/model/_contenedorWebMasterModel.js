define([], function() {
    App.Model._ContenedorWebMasterModel = Backbone.Model.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('contenedorWeb-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.ContenedorWebModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.contenedorWebEntity,options);
            }
        }
    });

    App.Model._ContenedorWebMasterList = Backbone.Collection.extend({
        model: App.Model._ContenedorWebMasterModel,
        initialize: function() {
        }

    });
    return App.Model._ContenedorWebMasterModel;
    
});