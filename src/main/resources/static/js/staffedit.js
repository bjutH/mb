$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

});


var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_departments').bootstrapTable({
            url: '../json/data1.json',                  //请求后台数据的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 14,                       //每页的记录行数（*）
            queryParamsType:"undefined",
            pageList: [10, 25, 50],        //可供选择的每页的行数（*）
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: false,                //是否启用点击选中行
            // height: 670,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "Name",                     //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            }, {
                field: 'Name',
                title: '姓名',
                editable: true
            }, {
                field: 'ParentName',
                title: '部门',
                editable: true
            }, {
                field: 'Level',
                title: '权限级别',
                editable: {
                    type: 'select',
                    pk: 1,
                    source: [
                        {value: '调度员', text: '调度员'},
                        {value: '管理员', text: '管理员'},
                        {value: '组长', text: '组长'},
                        {value: '游客', text: '游客'}
                    ],
                    noeditFormatter: function (value,row,index) {
                        var result={filed:"Level",value:value};
                        return result;
                    }
                }
            }, {
                field: 'Comment',
                title: '描述',
                editable: true
            }
            ],
            //提交修改后的数据
            onEditableSave: function (field, row, oldValue, $el) {
                $.ajax({
                    type: "POST",
                    url: "/？？？",    //提交修改后JSON的URL
                    data: row,        //row是提交的数据
                    dataType: 'JSON',

                    success: function (data, status) {
                        alert(JSON.stringify( row ));
                        // alert(JSON.stringify( data ));
                        if (status == "success") {
                            alert('提交数据成功');
                        }
                    },
                    error: function (data) {
                        alert(JSON.stringify( row ));
                        // alert(JSON.stringify( data ));
                        alert('+编辑失败+');
                    }
                    // complete: function () {
                    //
                    // }
                })
            }

        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            name: $("#txt_search_name").val(),
            statu: $("#txt_search_statu").val()
        };
        return temp;
    };
    return oTableInit;
};


var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};