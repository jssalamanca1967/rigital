define([], function() {
    App.Model._RepositorioMasterModel = Backbone.Model.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('repositorio-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.RepositorioModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.repositorioEntity,options);
            }
        }
    });

    App.Model._RepositorioMasterList = Backbone.Collection.extend({
        model: App.Model._RepositorioMasterModel,
        initialize: function() {
        }

    });
    return App.Model._RepositorioMasterModel;
    
});