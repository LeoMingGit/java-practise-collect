// public/config.js
// window.RuoYi_CONFIG = {
// 	BASE_URL: 'http://localhost:7004/prod-api',	// 后台接口地址 
// }

   //获取配置文件信息
if(!sessionStorage.getItem("RuoYiConfig")){
    let xhr=new XMLHttpRequest();
    xhr.open("GET","/config/config.json");
    xhr.send(null)
    xhr.onreadystatechange=()=>{
        if(xhr.status===200&&xhr.readyState===4){
            let config=JSON.parse(xhr.responseText);
            Object.keys(config).forEach(key=>sessionStorage.setItem(key,config[key]));
        }
    }
}
