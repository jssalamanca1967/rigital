define(['model/_mySQLMasterModel'], function() { 
    App.Model.MySQLMasterModel = App.Model._MySQLMasterModel.extend({

    });

    App.Model.MySQLMasterList = App.Model._MySQLMasterList.extend({
        model: App.Model.MySQLMasterModel
    });

    return  App.Model.MySQLMasterModel;

});