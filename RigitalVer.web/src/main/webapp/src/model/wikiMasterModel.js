define(['model/_wikiMasterModel'], function() { 
    App.Model.WikiMasterModel = App.Model._WikiMasterModel.extend({

    });

    App.Model.WikiMasterList = App.Model._WikiMasterList.extend({
        model: App.Model.WikiMasterModel
    });

    return  App.Model.WikiMasterModel;

});