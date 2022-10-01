//设置轮播图自动播放
$(function(){
    //标记当前图片索引
    var index=0;
    setInterval(function(){
        if(index==$(".box-image").length){
            index=-1;
        }
        $(".box-image").css("opacity",0);
        $(".box-image").eq(index++).css("opacity",1);
    },3000)

    //轮播图左右切换
    $("#left-button").click(function(){
        if(index==0){
            $(".botton01").css("background","#ccc");
            $(".botton01").eq(index).css("background-color","#fff");
        }
        else{
            index--;
            $(".box-image").css("opacity",0);
            $(".box-image").eq(index).css("opacity",1);
            $(".botton01").css("background","#ccc");
            $(".botton01").eq(index).css("background-color","#fff");
        }
        
    })
    $("#right-button").click(function(){
    
        if(index==$(".box-image").length-1){
           
           
        }
        else{
            index++;
            $(".box-image").css("opacity",0);
            $(".box-image").eq(index).css("opacity",1);
            $(".botton01").css("background","#ccc")
            $(".botton01").eq(index).css("background-color","#fff");
        }
        
    })
    //按照指定按钮切换轮播图
    $(".botton01").click(function(){
        var indexx=$(this).index();
        index=indexx;
        $(".box-image").css("opacity",0);
        $(".box-image").eq(index).css("opacity",1);
        //按钮激活
        // 如何通过添加选择器的方式来实现
        $(".botton01").css("background","#ccc")
        $(".botton01").eq(index).css("background-color","#fff");
    })

})

