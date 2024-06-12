const visitModel = require('../models/visitModel');

module.exports = {
    visitWebsite: (req, res) => {
        const { customerId, deviceId, websiteId } = req.body;
        visitModel.trackVisit(customerId, deviceId, websiteId);
        res.send({ message: 'Visit tracked successfully' });
    },

    getWebsiteVisitCountForCustomer: (req, res) => {
        const { customerId, websiteId } = req.query;
        const count = visitModel.getCustomerVisitCount(customerId, websiteId);
        res.send({ count });
    },

    getOverallWebsiteHitCount: (req, res) => {
        const { websiteId } = req.query;
        const count = visitModel.getOverallVisitCount(websiteId);
        res.send({ count });
    }
};
