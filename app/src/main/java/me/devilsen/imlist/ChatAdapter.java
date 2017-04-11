package me.devilsen.imlist;

import android.content.Context;
import android.util.Log;

import com.airbnb.epoxy.EpoxyAdapter;

import me.devilsen.imlist.message.UMessage;
import me.devilsen.imlist.message.UMessageImageContent;
import me.devilsen.imlist.message.UMessageTxtContent;
import me.devilsen.imlist.models.ChatImgModel_;
import me.devilsen.imlist.models.ChatTxtModel_;
import me.devilsen.imlist.view.ChatItemView;
import me.devilsen.imlist.view.ChatStatusView;

/**
 * author : dongSen
 * date : 2017/3/28
 * desc :
 */
public class ChatAdapter extends EpoxyAdapter {

//    private ChatTxtModel_ chatTxtModel = new ChatTxtModel_();

    ChatAdapter(Context context) {
        enableDiffing();

        long time = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)
                addModels(new ChatTxtModel_(context)
                        .message(new UMessage(new UMessageTxtContent("sss" + i)))
                        .userId("sss")
                        .direction(ChatItemView.RIGHT)
                        .time("18:00")
                        .avatar("http://tva4.sinaimg.cn/crop.112.0.266.266.180/9d0d09abjw8f48r8h0plhj20dw0dwgmg.jpg")
                        .status(ChatStatusView.FAIL));
            else
                addModels(new ChatTxtModel_(context)
                        .message(new UMessage(new UMessageTxtContent("aaa" + i)))
                        .userId("aaa")
                        .avatar("http://img4.imgtn.bdimg.com/it/u=1483569741,1992390913&fm=214&gp=0.jpg")
                        .direction(ChatItemView.LEFT)
                        .name("name" + i)
                        .status(ChatStatusView.SUCCESS));
        }

        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0)
                addModels(new ChatImgModel_(context)
                        .userId("sss")
                        .message(new UMessage(new UMessageImageContent("http://cdn.duitang.com/uploads/item/201405/29/20140529223850_wWs3H.thumb.600_0.jpeg")))
                        .direction(ChatItemView.RIGHT)
                        .avatar("http://tva4.sinaimg.cn/crop.112.0.266.266.180/9d0d09abjw8f48r8h0plhj20dw0dwgmg.jpg")
                        .status(ChatStatusView.FAIL));
            else
                addModels(new ChatImgModel_(context)
                        .direction(ChatItemView.LEFT)
                        .userId("aaa")
                        .message(new UMessage(new UMessageImageContent("http://img4.duitang.com/uploads/item/201403/20/20140320222513_dZf23.jpeg")))
                        .name("name" + i)
                        .avatar("http://img4.imgtn.bdimg.com/it/u=1483569741,1992390913&fm=214&gp=0.jpg")
                        .status(ChatStatusView.SUCCESS));
        }


        Log.e("time", System.currentTimeMillis() - time + "  ");

//        addModels(list);
    }

    public void setData() {
        notifyModelsChanged();
    }


}
