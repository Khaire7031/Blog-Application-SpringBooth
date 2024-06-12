const express = require('express');
const visitController = require('../controllers/visitController');

const router = express.Router();

router.post('/visit', visitController.visitWebsite);
router.get('/customer-visit-count', visitController.getWebsiteVisitCountForCustomer);
router.get('/overall-visit-count', visitController.getOverallWebsiteHitCount);

module.exports = router;
