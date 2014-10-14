define(['model/_contenedorWebMasterModel'], function() { 
    App.Model.ContenedorWebMasterModel = App.Model._ContenedorWebMasterModel.extend({

    });

    App.Model.ContenedorWebMasterList = App.Model._ContenedorWebMasterList.extend({
        model: App.Model.ContenedorWebMasterModel
    });

    return  App.Model.ContenedorWebMasterModel;

});