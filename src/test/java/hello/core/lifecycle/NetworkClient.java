package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 call url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call: " + url + " send: "  + message);
    }

    public void disconnect(){
        System.out.println("연결종료 : " + url );
    }

    @PreDestroy
    public void close() throws Exception {
        disconnect();
    }

    @PostConstruct
    public void init() throws Exception {
        connect();
        call("테스트 메세지");
    }
}
