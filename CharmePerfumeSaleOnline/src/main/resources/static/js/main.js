window.onload = function() {
    var date_input=$('input[name="date"]'); //our date input has the name "date"
	var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
	var options={
		format: 'dd/mm/yyyy',
		container: container,
		todayHighlight: true,
		autoclose: true
	};
	date_input.datepicker(options);
}

function setPrice() {
    var select = $('#unitPriceType').val();
    $('#price').val(select);
}

function setActiveItem() {
    var item = $('#itemId').text();
    $(item).addClass('active');
}

function changePageAndSize() {
	$('#pageSizeSelect').change(function(evt) {
		window.location.replace("/list-product-type?pageSize=" + this.value + "&page=1");
	});
}

function scrolify(tblAsJQueryObject, height){
    var oTbl = tblAsJQueryObject;

    // for very large tables you can remove the four lines below
    // and wrap the table with <div> in the mark-up and assign
    // height and overflow property
    var oTblDiv = $("<div/>");
    oTblDiv.css('height', height);
    oTblDiv.css('overflow','auto');
    oTbl.wrap(oTblDiv);

    // save original width
    oTbl.attr("data-item-original-width", oTbl.width());
    oTbl.find('thead tr td').each(function(){
        $(this).attr("data-item-original-width",$(this).width());
    });
    oTbl.find('tbody tr:eq(0) td').each(function(){
        $(this).attr("data-item-original-width",$(this).width());
    });

    // clone the original table
    var newTbl = oTbl.clone();

    // remove table header from original table
    oTbl.find('thead').remove();
    // remove table body from new table
    newTbl.find('tbody').remove();

    oTbl.parent().parent().prepend(newTbl);
    newTbl.wrap("<div/>");

    // replace ORIGINAL COLUMN width
    newTbl.width(newTbl.attr('data-item-original-width'));
    newTbl.find('thead tr td').each(function(){
        $(this).width($(this).attr("data-item-original-width"));
    });
    oTbl.width(oTbl.attr('data-item-original-width'));
    oTbl.find('tbody tr:eq(0) td').each(function(){
        $(this).width($(this).attr("data-item-original-width"));
    });
}
// Check valid date
function isDate(txtDate)
{
    var currVal = txtDate;
    if(currVal == '')
    	return false;

    //Declare Regex
    var rxDatePattern = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;
    var dtArray = currVal.match(rxDatePattern); // is format OK?

    if (dtArray == null)
    	return false;

    //Checks for dd/mm/yyyy format.
    dtDay = dtArray[1];
    dtMonth = dtArray[3];
    dtYear = dtArray[5];

    if (dtMonth < 1 || dtMonth > 12)
        return false;
    else if (dtDay < 1 || dtDay> 31)
        return false;
    else if ((dtMonth==4 || dtMonth==6 || dtMonth==9 || dtMonth==11) && dtDay ==31)
        return false;
    else if (dtMonth == 2)
    {
        var isleap = (dtYear % 4 == 0 && (dtYear % 100 != 0 || dtYear % 400 == 0));
        if (dtDay> 29 || (dtDay ==29 && !isleap))
        return false;
    }
    return true;
}

// Check valid date when click submit
$(function() {
    $('#btnSubmit').bind('click', function(){
    	$('#personForm').validator();
        var txtVal =  $('#birthDate').val();
        if(isDate(txtVal))
            // alert('Valid Date');
            // Do something ....
        	return true;
        else
            // alert('Invalid Date');
            // Do something ....
        	return false;
    });
});
