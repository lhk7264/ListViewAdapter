package com.example.listviewadapter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<ShopVO> list = new ArrayList<>();
        ShopVO vo1 =
                new ShopVO(R.drawable.a, "한방왕족발", "도마에 가지런히 담긴 부드러운 족발");
        list.add(vo1);
        ShopVO vo2 =
                new ShopVO(R.drawable.b, "귀화식당", "제철 생선회와 다양한 요리가 있는 선술집");
        list.add(vo2);
        ShopVO vo3 =
                new ShopVO(R.drawable.c, "맛순대", "개금골목시장 대표 순대집");
        list.add(vo3);
        ShopVO vo4 =
                new ShopVO(R.drawable.d, "황산밀면", "밀면의 참맛을 느낄 수 있는 곳");
        list.add(vo4);
        ShopVO
                vo5 = new ShopVO(R.drawable.e, "무비오빠", "진한 멸치육수와 최고의 술안주가 있는 곳");
        list.add(vo5);
        ListView listView = findViewById(R.id.list_view);
        ListViewAdapter adapter = new ListViewAdapter(this, R.layout.item, list);
        listView.setAdapter(adapter);

    }
}
class ListViewAdapter extends BaseAdapter {
    private Activity act;
    private  int layout;
    private  ArrayList<ShopVO> shopList;
    public  ListViewAdapter(Activity act, int layout, ArrayList<ShopVO> shopList){
        this.act = act;
        this.layout = layout;
        this.shopList = shopList;

    }

    @Override
    public int getCount() {
        return shopList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = act.getLayoutInflater();
        View v = inflater.inflate(layout,null);
        ImageView shopImg = v.findViewById(R.id.shop_img);
        TextView shopName = v.findViewById(R.id.shop_name);
        TextView shopDesc = v.findViewById(R.id.shop_desc);

        shopImg.setImageResource(shopList.get(position).getShopImg());
        shopName.setText(shopList.get(position).shopName);
        shopDesc.setText(shopList.get(position).shopDesc);

        return  v;

    }
}
class ShopVO {
    private  int shopImg;
    String shopName;
    String shopDesc;
    int getShopImg(){
        return shopImg;
    }
    public ShopVO(int shopImg, String shopName, String shopDesc) {
        this.shopImg = shopImg;
        this.shopName = shopName;
        this.shopDesc = shopDesc;
    }

}
