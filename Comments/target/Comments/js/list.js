/*
  查询
 */
$(function(){
    var basePath=$("#basePath").val();
    $("#searchBtn").click(function () {

        $("#myForm").attr("action",basePath+"/ad/selectAds");
        $("#myForm").submit();

    } )


    /*
    删除
     */
    function deleteAd(id) {
        $("#adId").attr("value",id);
        $("#myForm").attr("action",basePath+"/ad/deleteAd");
        $("#myForm").submit();

    }

    /*
    批量删除
     */
    $("#deleteBatchBtn").click(function () {
        $("#myForm").attr("action",basePath+"/ad/deleteBatchAd");
        $("#myForm").submit();
    })
})
