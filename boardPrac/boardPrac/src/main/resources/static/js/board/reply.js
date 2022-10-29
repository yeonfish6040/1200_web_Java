/**
 * reply module
 */

console.log("Reply module for replies")

let replyService = {
    get: (rno, callback, error) => {
        try {
            $.ajax({
                type: "GET",
                url: "/reply/"+rno,
                success: callback,
                error: error
            })
        } catch (e) {}
    },
    getList: (bno, page, callback, error) => {
        try {
            $.ajax({
                type: "GET",
                url: "/reply/pages/"+bno+"/"+(page||1),
                success: callback,
                error: error
            })
        } catch (e) {}
    },
        getTotal: (bno, page, callback, error) => {
        try {
            $.ajax({
                type: "GET",
                url: "/reply/pages/c/"+bno+"/"+(page||1),
                success: callback,
                error: error
            })
        } catch (e) {}
    },
    add: (reply, callback, error) => {
        try {
            $.ajax({
                type: "POST",
                url: "/reply/new",
                data: JSON.stringify(reply),
                contentType: "application/json; charset=utf-8",
                success: callback,
                error: error
            })
        } catch (e) {}
    },
    modify: (reply, callback, error) => {
        try {
            $.ajax({
                type: "PATCH",
                url: "/reply/new",
                data: JSON.stringify(reply),
                contentType: "application/json; charset=utf-8",
                success: callback,
                error: error
            })
        } catch (e) {}
    },
    remove: (rno, callback, error) => {
        try {
            $.ajax({
                type: "DELETE",
                url: "/reply/"+rno,
                success: callback,
                error: error
            })
        } catch (e) {}
    }
};