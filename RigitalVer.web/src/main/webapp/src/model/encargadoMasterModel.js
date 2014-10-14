define(['model/_encargadoMasterModel'], function() { 
    App.Model.EncargadoMasterModel = App.Model._EncargadoMasterModel.extend({

    });

    App.Model.EncargadoMasterList = App.Model._EncargadoMasterList.extend({
        model: App.Model.EncargadoMasterModel
    });

    return  App.Model.EncargadoMasterModel;

});