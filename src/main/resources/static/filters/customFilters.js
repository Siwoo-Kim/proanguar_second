
angular.module("customFilters", [])
    .filter("unique", function () {
        return function (data, propertyName) {
            if(angular.isArray(data) && angular.isString(propertyName)) {
                let result = [];
                let keys = {};
                angular.forEach(data, function (el) {
                   let value = el[propertyName];
                   if(angular.isUndefined(keys[value])) {
                       keys[value] = true;
                       result.push(value);
                   }
                });
                return result;
            }
            return data;
        }
    })
    .filter("range", function ($filter) {
        return function (data, page, pageSize) {
            if(angular.isArray(data) && angular.isNumber(page) && angular.isNumber(pageSize)) {
                let start_index = (page - 1) * pageSize;
                if(start_index < data.length) {
                    return $filter("limitTo")(data.splice(start_index), pageSize);
                } else {
                    return [];
                }
            }
            return data;
        }
    })
    .filter("pageCount", function () {
        return function (data, pageSize) {
            if(angular.isArray(data) && angular.isNumber(pageSize)) {
                let results = [];
                for(let i=0;i<Math.ceil(data.length/pageSize);i++) {
                    results.push(i);
                }
                return results;
            }
            return data;
        }
    });