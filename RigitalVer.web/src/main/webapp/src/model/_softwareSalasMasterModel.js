define([], function() {
    App.Model._SoftwareSalasMasterModel = Backbone.Model.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('softwareSalas-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.SoftwareSalasModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.softwareSalasEntity,options);
            }
        }
    });

    App.Model._SoftwareSalasMasterList = Backbone.Collection.extend({
        model: App.Model._SoftwareSalasMasterModel,
        initialize: function() {
        }

    });
    return App.Model._SoftwareSalasMasterModel;
    
});