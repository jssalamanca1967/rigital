define([], function() {
    App.Model._WikiMasterModel = Backbone.Model.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('wiki-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.WikiModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.wikiEntity,options);
            }
        }
    });

    App.Model._WikiMasterList = Backbone.Collection.extend({
        model: App.Model._WikiMasterModel,
        initialize: function() {
        }

    });
    return App.Model._WikiMasterModel;
    
});