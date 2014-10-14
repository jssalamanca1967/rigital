define(['model/_softwareSalasMasterModel'], function() { 
    App.Model.SoftwareSalasMasterModel = App.Model._SoftwareSalasMasterModel.extend({

    });

    App.Model.SoftwareSalasMasterList = App.Model._SoftwareSalasMasterList.extend({
        model: App.Model.SoftwareSalasMasterModel
    });

    return  App.Model.SoftwareSalasMasterModel;

});