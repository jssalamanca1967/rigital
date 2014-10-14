define(['model/_repositorioMasterModel'], function() { 
    App.Model.RepositorioMasterModel = App.Model._RepositorioMasterModel.extend({

    });

    App.Model.RepositorioMasterList = App.Model._RepositorioMasterList.extend({
        model: App.Model.RepositorioMasterModel
    });

    return  App.Model.RepositorioMasterModel;

});