INSERT INTO SM_Resources VALUES ('1', '系统基础管理', '0', 'system', '0', 'system', '0', '系统基础管理');
INSERT INTO SM_Resources VALUES ('2', '账号管理', '1', 'account', '1', '/user/list.html', '1', '账号管理');
INSERT INTO SM_Resources VALUES ('3', '角色管理', '1', 'role', '1', '/role/list.html', '5', '角色管理');
INSERT INTO SM_Resources VALUES ('4', '菜单管理', '1', 'resources', '1', '/resources/list.html', '10', '菜单查询');


INSERT INTO `SM_UserRoleMapping` VALUES ('1', '2');
INSERT INTO `SM_UserRoleMapping` VALUES ('1', '3');
INSERT INTO `SM_UserRoleMapping` VALUES ('1', '4');


INSERT INTO `sm_role` VALUES ('2', '1', '管理员', 'admin', '管理系统权限');
INSERT INTO `sm_role` VALUES ('3', '1', '普通角色', 'simple', '普通角色');
INSERT INTO `sm_role` VALUES ('4', '1', '根账号', 'root', '拥有所有权限1');



INSERT INTO `SM_ResourcesRoleMapping` VALUES ('4', '1');
INSERT INTO `SM_ResourcesRoleMapping` VALUES ('4', '2');
INSERT INTO `SM_ResourcesRoleMapping` VALUES ('4', '3');
INSERT INTO `SM_ResourcesRoleMapping` VALUES ('4', '4');