define(['model/_unidadDeRedMasterModel'], function() { 
    App.Model.UnidadDeRedMasterModel = App.Model._UnidadDeRedMasterModel.extend({

    });

    App.Model.UnidadDeRedMasterList = App.Model._UnidadDeRedMasterList.extend({
        model: App.Model.UnidadDeRedMasterModel
    });

    return  App.Model.UnidadDeRedMasterModel;

});