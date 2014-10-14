define(['model/_paginaWebMasterModel'], function() { 
    App.Model.PaginaWebMasterModel = App.Model._PaginaWebMasterModel.extend({

    });

    App.Model.PaginaWebMasterList = App.Model._PaginaWebMasterList.extend({
        model: App.Model.PaginaWebMasterModel
    });

    return  App.Model.PaginaWebMasterModel;

});