package org.devops

//钉钉推送消息
//def dingtalk( LinkedHashMap<String, Object> ){
def dingtalk(){
    dingtalk (
        robot: '1f742f6b-4ba5-4bb8-aa42-6a292b740da3',
        type: 'ACTION_CARD',
        title: 'Jenkins',
        text:[
              "[${JOB_NAME}](${JOB_URL})[项目构建通知]\n",
              "-------",
              "- 任务: [#${BUILD_ID}](${BUILD_URL})",
              "- 状态: <font color=#52C41A>${currentBuild.currentResult}</font>",
              "- 持续时间: ${currentBuild.durationString}\n",
              "- 构建分支: ${branch}",
        ],
        btns: [
            [
                title: '日志',
                actionUrl: "${BUILD_URL}"
            ],
            [
                title: '控制台',
                actionUrl: 'jenkinsserverip'
            ]
        ]
    )    
}

