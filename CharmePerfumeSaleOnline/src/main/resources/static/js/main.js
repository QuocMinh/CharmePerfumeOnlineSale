$(document).ready(function() {
    setActiveItem();
});

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
