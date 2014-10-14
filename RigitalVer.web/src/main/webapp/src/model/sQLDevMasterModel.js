define(['model/_sQLDevMasterModel'], function() { 
    App.Model.SQLDevMasterModel = App.Model._SQLDevMasterModel.extend({

    });

    App.Model.SQLDevMasterList = App.Model._SQLDevMasterList.extend({
        model: App.Model.SQLDevMasterModel
    });

    return  App.Model.SQLDevMasterModel;

});