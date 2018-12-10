package com.example.test.db_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.test.db_project.Custom_Dataset.reserved_room;
import com.example.test.db_project.Custom_Dataset.reserved_room_Adapter;
import com.example.test.db_project.Custom_Dataset.room_list_adapter;
import com.example.test.db_project.Custom_Dataset.staff_room_data;


import java.util.ArrayList;

public class Staff_Reservation extends AppCompatActivity {
    ListView reservation_list;
    reserved_room_Adapter ra1;
    ArrayList<reserved_room> reserved_roomArrayList;
    Intent intent;
    String staffID;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_reservation);
        intent = getIntent();
        staffID = intent.getStringExtra("staffID");

        reservation_list = findViewById(R.id.reservation_list);
        reserved_roomArrayList = new ArrayList<>();
        ra1 = new reserved_room_Adapter(Staff_Reservation.this, reserved_roomArrayList);
        reservation_list.setAdapter(ra1);
        b1 = findViewById(R.id.recreate);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Staff_Reservation.this.recreate();
            }
        });
        Get_DB<reserved_room, reserved_room_Adapter> get_db = new Get_DB<>(7, reserved_roomArrayList, ra1);
        get_db.execute("reservation.php","sql=select ifnull(staffID,0), begin, end, name, phone_num, type, view, reservID from reservation natural join guest order by reserv_date");

        Log.e("test6", staffID);
        reservation_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final View dialog = View.inflate(Staff_Reservation.this, R.layout.staff_reservation_dialog, null);
                ListView lv1 = dialog.findViewById(R.id.room_avail);
                final String[] begin = reserved_roomArrayList.get(position).getDate().split("\n");
                final String[] end = begin[1].split("~");

                final String reservID = reserved_roomArrayList.get(position).getReservID();
                final ArrayList<staff_room_data> data = new ArrayList<>();
                room_list_adapter adapter = new room_list_adapter(dialog.getContext(),data);
                lv1.setAdapter(adapter);

                Get_DB<staff_room_data, room_list_adapter> get_db = new Get_DB<>(4, data, adapter);
                get_db.execute("room.php","sql=select roomID, availability, ifnull(begin, '0'), ifnull(end,'0')from availability natural join room where (availability = 'yes' and type = '"
                        +reserved_roomArrayList.get(position).getType()+" ' and view = '"+reserved_roomArrayList.get(position).getView()+"')");


                final AlertDialog.Builder builder = new AlertDialog.Builder(Staff_Reservation.this);

                final DialogInterface mPopupDlg =  builder.setView(dialog).show();
                lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Log.e("test6",data.get(position).getRoom());
                        Send_DB send_db = new Send_DB(dialog.getContext(),5);
                        send_db.execute("update_reservation.php","sql=update reservation set roomID="+data.get(position).getRoom()+" where reservID="+reservID+
                                "| update reservation set staffID = "+staffID+" where reservID="+ reservID +
                                "| update availability set begin='"+begin[0]+"' where roomID="+data.get(position).getRoom()+
                                "| update availability set end='"+end[1]+"' where roomID="+data.get(position).getRoom()+
                                "| update availability set availability='no' where roomID="+data.get(position).getRoom());
                        mPopupDlg.dismiss();
                        Log.e("test1", begin[0]+end[1]);
                    }
                });
//                Get_DB<reserved_room, reserved_room_Adapter> get_db = new Get_DB<>(7, reserved_roomArrayList, ra1);
//                get_db.execute("reservation.php","sql=select ifnull(roomID, 0), ifnull(reserv_date,'null'), name from reservation natural join guest order by reserv_date");
            }
        });
    }
}
