package com.wnf.controller;

import com.wnf.entity.Tutor;
import com.wnf.entity.Users;
import com.wnf.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *               ┏┓        ┏┓+ +
 *　　　　　　　┏┛┻━━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　    ┃
 *　　　　　　　┃　　   ━　　　 ┃ ++ + + +
 *　　　　　　 ████━████ ┃+
 *　　　　　　　┃　　　　　　    ┃ +
 *　　　　　　　┃　　　┻　　　  ┃
 *　　　　　　　┃　　　　　　    ┃ + +
 *　　　　　　　┗━━┓　　　┏━┛
 *                   ┃　　  ┃
 *　　　　　　　　　  ┃　　  ┃ + + + +
 *　　　　　　　　　  ┃　　　┃　Code is far away from     bug with the animal protecting
 *　　　　　　　　　  ┃　　　┃ + 　　　　         神兽保佑,代码无bug
 *　　　　　　　　　  ┃　　　┃
 *　　　　　　　　　  ┃　　　┃　　+
 *　　　　　　　　　  ┃　 　 ┗━━━━┓ + +
 *　　　　　　　　　  ┃ 　　　　　     ┣┓
 *　　　　　　　　　  ┃ 　　　　　     ┏┛
 *　　　　　　　　　  ┗┓┓┏━━┳┓┏┛ + + + +
 *　　　　　　　　　    ┃┫┫　  ┃┫┫
 *　　　　　　　　　    ┗┻┛　  ┗┻┛+ + + +
 */

//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                      Buddha Bless, No Bug !
//
//                       .::::.
//                     .::::::::.
//                    :::::::::::
//                 ..:::::::::::'
//              '::::::::::::'
//                .::::::::::
//           '::::::::::::::..
//                ..::::::::::::.
//              ``::::::::::::::::
//               ::::``:::::::::'        .:::.
//              ::::'   ':::::'       .::::::::.
//            .::::'      ::::     .:::::::'::::.
//           .:::'       :::::  .:::::::::' ':::::.
//          .::'        :::::.:::::::::'      ':::::.
//         .::'         ::::::::::::::'         ``::::.
//     ...:::           ::::::::::::'              ``::.
//    ```` ':.          ':::::::::'                  ::::..
//                       '.:::::'                    ':'````..
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//
//      ┏┛┻━━━━━┛┻┓
//      ┃　　　　　　      ┃
//      ┃　　　━　　　    ┃
//      ┃　┳┛　  ┗┳　  ┃
//      ┃　　　　　　      ┃
//      ┃　　　┻　　    　┃
//      ┃　　　　　　      ┃
//      ┗━┓　　　┏━━━┛
//          ┃　　　┃   神兽保佑
//          ┃　　　┃   代码无BUG！
//          ┃　　　┗━━━━━━━━━┓
//          ┃　　　　　　　            ┣┓
//          ┃　　　　                  ┏┛
//          ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//              ┃ ┫ ┫      ┃ ┫ ┫
//             ┗━┻━┛    ┗━┻━┛
@RestController
public class TutorController {

    @Autowired
    TutorService tutorService;

    /**
     * 获取老师的及其所教的课程，mybatis的一对多查询
     * @param tutorId
     * @return
     */
    @RequestMapping("tutor/{tutorId}")
    public Tutor tutorList(@PathVariable("tutorId") int tutorId) {
        Tutor tutor = tutorService.findTutorById(tutorId);
        return tutor;
    }

    @RequestMapping("tutor/add")
    public String tutoradd() {
        Users users = new Users();
        users.setUname("名字");
        String result = "error";
        try {
            result = tutorService.addUser(users);
        } catch (Exception e) {
            result = "error:" + e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

}
