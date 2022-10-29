let attachServices = {
    upload: (formData, callback, error) => {
        $.ajax({
            url: "/board/post/uploadAjaxAction",
            processData: false,
            contentType: false,
            type: "POST",
            data: formData,
            success: callback,
            error: error
        })
    }
}