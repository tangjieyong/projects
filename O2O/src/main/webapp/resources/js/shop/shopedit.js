/*
  页面加载完毕后使用AJAX来查询店铺的信息,并填入对应的文本框中
 */
$(function () {
    var shopInfoUrl="/o2o/shop/getShopInfo?shopId=15";
    var shopRegister="/o2o/shop/registerShop";

      initForm();
    //异步加载获得服务器的数据，生成商铺分类和所属区域的下来列表
    function initForm() {
        $.getJSON(shopInfoUrl,function (data) {
            if (data !=null){
                var tempHtml='';
                var tempAreaHtml='';
                //将分类信息集合获取遍历生成下拉列表
                data.shopCategoryList.map(function (item, index) {
                    tempHtml+='<option data-id="'+item.shopCategoryId+'">'+item.shopCategoryName+'</option>'
                });
                //将区域集合获取遍历生成下拉列表
                data.areaList.map(function (item,index) {
                    tempAreaHtml+='<option data-id="+'+item.areaId+'">'+item.areaName+'</option>'
                });
                $("#shop-category").html(tempHtml);
                $('#shop-category').removeAttr('disabled');
                $("#area").html(tempAreaHtml);
            }else{

            }
        })
    }

// 点击表单的提交按钮，将表单的字段值获得转化为JSON
    $('#submit').click(function() {
        var shop = {};

        shop.shopName = $('#shop-name').val();
        shop.shopAddr = $('#shop-addr').val();
        shop.phone = $('#shop-phone').val();
        shop.shopDesc = $('#shop-desc').val();

        shop.shopCategory = {
            shopCategoryId : $('#shop-category').find('option').not(function() {
                return !this.selected;
            }).data('id')
        };
        shop.area = {
            areaId : $('#area').find('option').not(function() {
                return !this.selected;
            }).data('id')
        };

        var shopImg = $("#shop-img")[0].files[0];
        var formData = new FormData();

        formData.append('shopImg', shopImg);
        formData.append('shopStr', JSON.stringify(shop));
        //获取输入的验证码
        var verifyCode=$("#j_captcha").val();
        if(!verifyCode){
            $.toast("请输入验证码");
            return;
        }
        formData.append("verifyCode",verifyCode);
        $.ajax({
            url : shopRegister,
            type : 'POST',
            data : formData,
            // contentType:'application/x-www-form-urlencoded',
            processData: false,
            contentType:false,
            success : function(data) {
                if(data.msg){
                    $.toast(data.msg);
                    return;
                }
                if(data.stateCode>=0){
                    $.toast("添加成功，审核中");
                }else{$.toast("添加失败，请检查输入参数");}
            }
        });
    });





})
/*
查询商铺分类和所属区域，生成列表
 */


/*
  使用AJAX技术来提交表单，以json数据格式提交给服务器
 */