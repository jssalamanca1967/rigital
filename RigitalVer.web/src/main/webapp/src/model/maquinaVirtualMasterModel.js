define(['model/_maquinaVirtualMasterModel'], function() { 
    App.Model.MaquinaVirtualMasterModel = App.Model._MaquinaVirtualMasterModel.extend({

    });

    App.Model.MaquinaVirtualMasterList = App.Model._MaquinaVirtualMasterList.extend({
        model: App.Model.MaquinaVirtualMasterModel
    });

    return  App.Model.MaquinaVirtualMasterModel;

});