/**
 * Created by avborg on 30.10.2016.
 */
$.validator.addMethod("anyDate",
    function(value, element) {
        if (value == "") {
            return true;
        }
        return value.match(/^(0?[1-9]|[12][0-9]|3[0-1])[/., -](0?[1-9]|1[0-2])[/., -]\d{4}$/);
    }, "Пожалуйста, введите корректную дату. В формате ДД.ММ.ГГГГ");


function validPlaceError(error, element) {
    $(element).next().text($(error).text()).css("color", "red");
}

function validPlaceSuccess(label, element) {
    $(element).next().empty().css("color", "black");
}