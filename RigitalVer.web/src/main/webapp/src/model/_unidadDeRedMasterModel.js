define([], function() {
    App.Model._UnidadDeRedMasterModel = Backbone.Model.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('unidadDeRed-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.UnidadDeRedModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.unidadDeRedEntity,options);
            }
        }
    });

    App.Model._UnidadDeRedMasterList = Backbone.Collection.extend({
        model: App.Model._UnidadDeRedMasterModel,
        initialize: function() {
        }

    });
    return App.Model._UnidadDeRedMasterModel;
    
});