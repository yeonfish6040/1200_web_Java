module.exports = {
    name: 'date',
    description: `date test`,

    run: function() {
        /**
         * getFullYear
         * getMonth
         * getDate
         * getDay
         * getHours
         * getMinutes
         * getSeconds
         * getMilliseconds
         * getTime
         * get -> set
         */

        var now = new Date()
        console.log(now.toUTCString());
        console.log(now.toLocaleString());
    }
}