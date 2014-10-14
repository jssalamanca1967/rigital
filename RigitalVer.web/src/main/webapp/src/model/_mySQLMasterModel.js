define([], function() {
    App.Model._MySQLMasterModel = Backbone.Model.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('mySQL-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.MySQLModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.mySQLEntity,options);
            }
        }
    });

    App.Model._MySQLMasterList = Backbone.Collection.extend({
        model: App.Model._MySQLMasterModel,
        initialize: function() {
        }

    });
    return App.Model._MySQLMasterModel;
    
});