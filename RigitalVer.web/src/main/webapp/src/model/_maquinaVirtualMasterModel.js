define([], function() {
    App.Model._MaquinaVirtualMasterModel = Backbone.Model.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('maquinaVirtual-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.MaquinaVirtualModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.maquinaVirtualEntity,options);
            }
        }
    });

    App.Model._MaquinaVirtualMasterList = Backbone.Collection.extend({
        model: App.Model._MaquinaVirtualMasterModel,
        initialize: function() {
        }

    });
    return App.Model._MaquinaVirtualMasterModel;
    
});