function ChangeDateFormat(date) {
    var date = new Date(date)
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var hour = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds();
    // return year + "-" + formatTen(month) + "-" + formatTen(day)+ " " +formatTen(hour)+ ":" +formatTen(minute)+ ":" +formatTen(second);
    return year + "-" + formatTen(month) + "-" + formatTen(day);
}
function formatTen(num) {
    return num > 9 ? (num + "") : ("0" + num);
}


// ===========================搜索模块=======================================

var getbtn=document.querySelector(".getbtn");
getbtn.onclick=function () {
    var xhr = new XMLHttpRequest();
    var url = "/javaweb_demo/ajax_product";
    var getkey=document.querySelector(".getkey").value;
    var data = "option=getoneproduct&getkey="+getkey;
    xhr.open("POST",url,true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xhr.onreadystatechange=function () {
        if (xhr.readyState==4){
            if (xhr.status==200){
                var result = JSON.parse(xhr.responseText);
                if (result.code==0){
                    document.querySelector(".getmsg").innerText=result.message;
                    setTimeout(function () {
                        document.querySelector(".getmsg").innerText="";
                    },3000)
                }else {
                    var datejson= result.data.proDate;
                    var date = ChangeDateFormat(datejson);
                    document.querySelector(".getmsg").innerText="";
                    document.querySelector(".detail").innerHTML=`商品_ID :${result.data.proId}<br>          
                        商品名称:${result.data.proName}<br>
                        商品编号:${result.data.proNum}<br>            
                        商品价格:${result.data.proPrice}<br>
                        商品产地:${result.data.proAddress}<br>
                        商品颜色:${result.data.proColor}<br>
                        商品尺寸:${result.data.proSize}<br>
                        生产日期:${date}<br>`;
                }
            }
        }
    }
    xhr.send(data);
}

// ====================================添加模块============================================
var addbtn = document.querySelector(".addbtn");
addbtn.onclick=function () {
    var xhr = new XMLHttpRequest();

    var url = "/javaweb_demo/ajax_product";
    var proName=document.querySelector(".proName_add").value;
    var proNum=document.querySelector(".proNum_add").value;
    var proPrice=document.querySelector(".proPrice_add").value;
    var proAddress=document.querySelector(".proAddress_add").value;
    var proColor=document.querySelector(".proColor_add").value;
    var proSize=document.querySelector(".proSize_add").value;
    var proDate=document.querySelector(".proDate_add").value;

    var data = "option=addproduct&proName="+proName+"&proNum="+proNum+"&proPrice="+proPrice+"&proAddress="+proAddress+"&proColor="+proColor+"&proSize="+proSize+"&proDate="+proDate;
    xhr.open("POST",url,true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xhr.onreadystatechange=function () {
        if (xhr.readyState==4){
            if (xhr.status==200){
                var result = JSON.parse(xhr.responseText);
                document.querySelector(".addmsg").innerText=result.message;
                setTimeout(function () {
                    document.querySelector(".addmsg").innerText="";
                },3000)
            }
        }
    }
    xhr.send(data);
}

// ====================================全部商品模块============================================
var allbtn = document.querySelector(".allbtn");
allbtn.onclick=function () {
    getall(1);
};
var prebtn = document.querySelector(".prePage");
prebtn.onclick=function () {
    var pageNum = document.querySelector(".pageNum").innerText;
    getall(parseInt(pageNum)-1);
};
var nextbtn = document.querySelector(".nextPage");
nextbtn.onclick=function () {
    var pageNum = document.querySelector(".pageNum").innerText;
    getall(parseInt(pageNum)+1);
};
function getall(pageNum) {
    var xhr = new XMLHttpRequest();
    var url = "/javaweb_demo/ajax_product";
    var data = "option=getallproduct&pageNum="+pageNum;
    xhr.open("POST",url,true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xhr.onreadystatechange=function () {
        if (xhr.readyState==4){
            if (xhr.status==200){
                var result = JSON.parse(xhr.responseText);
                if (result.code==0){
                    document.querySelector(".getallmsg").innerText=result.message;
                    setTimeout(function () {
                        document.querySelector(".getallmsg").innerText="";
                    },3000)
                }else {
                    var pages = result.data.pages;
                    var total = result.data.total;
                    var datalist= result.data.list;
                    document.querySelector(".allul").innerHTML=`
                        <li><span>商品名称</span>
                            <span>商品编号</span>
                            <span>商品价格</span>
                            <span>商品产地</span>
                            <span>商品颜色</span>
                            <span>商品尺寸</span>
                            <span>生产日期</span>
                            <span>操作1</span>
                            <span>操作2</span>
                        </li>`;
                    for (var i=0;i<datalist.length;i++){
                        var date = ChangeDateFormat(datalist[i].proDate);
                        document.querySelector(".allul").innerHTML+=`
                        <li><input type="hidden" value="${datalist[i].proId}">
                            <span>${datalist[i].proName}</span>
                            <span>${datalist[i].proNum}</span>
                            <span>${datalist[i].proPrice}</span>
                            <span>${datalist[i].proAddress}</span>
                            <span>${datalist[i].proColor}</span>
                            <span>${datalist[i].proSize}</span>
                            <span>${date}</span>
                            <span><button onclick="modifygo(event)" class="modbtn" style="width: 100%;height: 100%;background-color: orange">修改</button></span>
                            <span><button onclick="deletego(event)" class="delbtn" style="width: 100%;height: 100%;background-color: orange">删除</button></span>
                        </li>`;
                    }
                    if (pageNum==1){
                        document.querySelector(".prePage").style.visibility="hidden";

                    }else if (pageNum==pages) {
                        document.querySelector(".nextPage").style.visibility="hidden";
                    }else {
                        document.querySelector(".prePage").style.visibility="visible";
                        document.querySelector(".nextPage").style.visibility="visible";
                    }
                    document.querySelector(".pageNum").innerText=pageNum;
                    document.querySelector(".pages").innerText=pages;
                    document.querySelector(".total").innerText=total;
                    document.querySelector(".pagearea").style.visibility="visible";
                }
            }
        }
    }
    xhr.send(data);
}

// ====================================修改模块============================================
function modifygo(event) {
     var liElement = event.target.parentElement.parentElement;
     var proId = liElement.children[0].value;
     var proName = liElement.children[1].innerText;
     var proNum = liElement.children[2].innerText;
     var proPrice = liElement.children[3].innerText;
     var proAddress = liElement.children[4].innerText;
     var proColor = liElement.children[5].innerText;
     var proSize = liElement.children[6].innerText;
     var proDate = liElement.children[7].innerText;
     document.querySelector(".proId_modify").value=proId;
     document.querySelector(".proName_modify").value=proName;
     document.querySelector(".proNum_modify").value=proNum;
     document.querySelector(".proPrice_modify").value=proPrice;
     document.querySelector(".proAddress_modify").value=proAddress;
     document.querySelector(".proColor_modify").value=proColor;
     document.querySelector(".proSize_modify").value=proSize;
     document.querySelector(".proDate_modify").value=proDate;
}
var modifybtn = document.querySelector(".modifybtn");

modifybtn.onclick=function () {
    var xhr = new XMLHttpRequest();
    var url = "/javaweb_demo/ajax_product";
    var proId=document.querySelector(".proId_modify").value;
    var proName=document.querySelector(".proName_modify").value;
    var proNum=document.querySelector(".proNum_modify").value;
    var proPrice=document.querySelector(".proPrice_modify").value;
    var proAddress=document.querySelector(".proAddress_modify").value;
    var proColor=document.querySelector(".proColor_modify").value;
    var proSize=document.querySelector(".proSize_modify").value;
    var proDate=document.querySelector(".proDate_modify").value;

    var data = "option=modifyproduct&proId="+proId+"&proName="+proName+"&proNum="+proNum+"&proPrice="+proPrice+"&proAddress="+proAddress+"&proColor="+proColor+"&proSize="+proSize+"&proDate="+proDate;
    xhr.open("POST",url,true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xhr.onreadystatechange=function () {
        if (xhr.readyState==4){
            if (xhr.status==200){
                var result = JSON.parse(xhr.responseText);
                document.querySelector(".modifymsg").innerText=result.message;
                setTimeout(function () {
                    document.querySelector(".modifymsg").innerText="";
                },3000)
                if (result.code==1){
                    document.querySelector(".proId_modify").value="";
                    document.querySelector(".proName_modify").value="";
                    document.querySelector(".proNum_modify").value="";
                    document.querySelector(".proPrice_modify").value="";
                    document.querySelector(".proAddress_modify").value="";
                    document.querySelector(".proColor_modify").value="";
                    document.querySelector(".proSize_modify").value="";
                    document.querySelector(".proDate_modify").value="";
                }
            }
        }
    }
    xhr.send(data);
}



// ====================================删除模块============================================
function deletego(event){
    if (confirm("确认是否删除！")) {
        var proId = event.target.parentElement.parentElement.firstElementChild.value;

        var xhr = new XMLHttpRequest();
        var url = "/javaweb_demo/ajax_product";
        var data = "option=deleteproduct&proId="+proId;
        xhr.open("POST",url,true);
        xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        xhr.onreadystatechange=function () {
            if (xhr.readyState==4){
                if (xhr.status==200){
                    var result = JSON.parse(xhr.responseText);
                    confirm(result.message)
                }
            }
        }
        xhr.send(data);
    }
}