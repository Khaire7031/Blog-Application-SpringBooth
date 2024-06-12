// In-memory data structures to store visit data
const visits = {}; // { websiteId: { customerId: Set(deviceIds) } }

module.exports = {
    trackVisit: (customerId, deviceId, websiteId) => {
        if (!visits[websiteId]) {
            visits[websiteId] = {};
        }
        if (!visits[websiteId][customerId]) {
            visits[websiteId][customerId] = new Set();
        }
        visits[websiteId][customerId].add(deviceId);
    },

    getCustomerVisitCount: (customerId, websiteId) => {
        return visits[websiteId] && visits[websiteId][customerId] ? visits[websiteId][customerId].size : 0;
    },

    getOverallVisitCount: (websiteId) => {
        let count = 0;
        if (visits[websiteId]) {
            for (const customerId in visits[websiteId]) {
                count += visits[websiteId][customerId].size;
            }
        }
        return count;
    }
};
