adminTable();

function adminTable() {
	 
	  console.log($("#adminSelectName").val())
	$('#adminTable').datagrid({
		url : 'requestAdminInquery.do',
		columns : [ [ {
			field : 'accountId',
			title : '管理员',
			width : 100,
			checkbox : true
		}, {
			field : 'accountName',
			title : '管理员名称',
			width : 100
		}, {
			field : 'remark',
			title : '备注',
			width : 100
		}, {
			field : 'createDate',
			title : '创建时间',
			width : 100
		}

		] ],
		// 分页
		pagination : true,
		singleSelect : true,
		pageList : [ 5, 10, 15, 20, 25, 30 ],
		fitColumns : true,
		queryParams: {
			"adminSelectName": $("#adminSelectName").val(),
		},
		rownumbers:true

	})
}

// 工具栏
$('#adminTable').datagrid({
	toolbar : '#AdminToolbar'
});


// 增加
function adminadd() {
	$('#adminAdd').dialog({
		title : '管理员增加',
		width : 600,
		height : 400,
		closed : false,
		cache : false,
		href : 'requestAdminAdd.do',
		modal : true
	});
}




// 修改
function adminUpdate() {

	var rows = $('#adminTable').datagrid('getSelections');

	if (rows.length != 0) {

		$('#adminUpdate').dialog({
			title : '管理员修改',
			width : 600,
			height : 400,
			closed : false,
			cache : false,
			href : 'requestadminUpdate.do',
			modal : true
		});
		var id = rows[0].accountId;
		$.ajax({
			type : 'post',
			url : "requestAdminupdate.do",
			data : {
				"id" : id

			},
			success : function(data) {
				console.log(data.accountName)
				console.log(data)
				// $('#name').combobox('setText', data.accountName);
				$("#idNone").val(data.accountId);
				$("#name").val(data.accountName);
				$("#pwdNone").val(data.accountPassWord);
				$("#bz").val(data.remark);

			}
		})

	} else {
		$.messager.alert('警告操作', '删除只能选定一条数据', 'warning');

	}

}





// 增加
function adminAddMysql() {
	var name = $("#name").val();
	var pwd = $("#pwd").val();
	var bz = $("#bz").val();
	$.ajax({
		type : 'post',
		url : "requestAdminAddMysql.do",
		data : {
			"name" : name,
			"pwd" : pwd,
			"bz" : bz
		},
		success : function(data) {

			if (data != "2") {
				$.messager.alert('账号', '增加成功账号为：' + data);
				$('#adminTable').datagrid('reload');
				$('#adminAdd').dialog('close').form('reset');
			} else {
				$.messager.alert('错误', '增加失败');
			}

		}
	})

}




// 修改进入数据库
function adminUpdateMysql() {
	var idNone = $("#idNone").val();
	var name = $("#name").val();
	var pwdNone = $("#pwdNone").val();

	var pwd = $("#pwd").val();
	var bz = $("#bz").val();
	$.ajax({
		type : 'post',
		url : "requestAdminUpdateMysql.do",
		data : {
			"idNone" : idNone,
			"pwdNone" : pwdNone,
			"name" : name,
			"pwd" : pwd,
			"bz" : bz
		},
		success : function(data) {

			if (data != "2") {
				$.messager.alert('账号', '修改成功');
				$('#adminTable').datagrid('reload');
				$('#adminUpdate').dialog('close').form('reset');
			} else {
				$.messager.alert('错误', '增加失败');
			}

		}
	})

}




// 删除
function adminDelete() {
	var rows = $('#adminTable').datagrid('getSelections');
	if (rows.length < 1) {
		$.messager.alert('警告操作', '删除只能选定一条数据', 'warning');
	} else {
		var id = rows[0].accountId;
		$.ajax({
			type : 'post',
			url : "requestAdmindeleteMysql.do",
			data : {
				"id" : id
			},
			success : function(data) {

				if (data == 1) {
					$.messager.alert('提示信息', '删除成功');
					$('#adminTable').datagrid('reload');
				}

			}
		})

	}
}