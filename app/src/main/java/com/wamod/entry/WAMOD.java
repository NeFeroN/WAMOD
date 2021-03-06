package com.wamod.entry;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.wamod.Resources;
import com.wamod.Utils;
import com.whatsapp.*;

/**
 * Created by brianvalente on 9/21/15.
 */
public class WAMOD {
    public static void init(final com.whatsapp.Conversation activity) {
        final View footer = activity.findViewById(Resources.id.footer);
        final Drawable bg = activity.getResources().getDrawable(Resources.drawable.wamod_theme_wamod_conversation_input);
        final FrameLayout inputBg = (FrameLayout) activity.findViewById(Resources.id.input_layout);
        final EditText entry = (EditText) activity.findViewById(Resources.id.entry);
        final ImageButton gallery = (ImageButton) activity.findViewById(Resources.id.wamod_theme_wamod_conversation_gallery);
        final ImageButton audio = (ImageButton) activity.findViewById(Resources.id.wamod_theme_wamod_conversation_audio);
        final ImageButton location = (ImageButton) activity.findViewById(Resources.id.wamod_theme_wamod_conversation_location);
        final ImageButton contact = (ImageButton) activity.findViewById(Resources.id.wamod_theme_wamod_conversation_contact);
        final ImageButton camera = (ImageButton) activity.findViewById(Resources.id.wamod_theme_wamod_conversation_camera);
        final ImageButton send = (ImageButton) activity.findViewById(Resources.id.send);
        final ImageButton voicenote = (ImageButton) activity.findViewById(Resources.id.voice_note_btn);
        final ImageButton emojibtn = (ImageButton) activity.findViewById(Resources.id.emoji_picker_btn);

        entry.clearFocus();


        footer.setBackgroundColor(Color.parseColor("#" + Utils.prefs.getString("theme_wamod_conversation_entry_bgcolor", "ffffff")));
        bg.setColorFilter(Color.parseColor("#" + Utils.prefs.getString("theme_wamod_conversation_entry_entrybgcolor", "ffffff")), PorterDuff.Mode.MULTIPLY);
        inputBg.setBackground(bg);

        entry.setHintTextColor(Color.parseColor("#" + Utils.prefs.getString("theme_wamod_conversation_entry_hinttextcolor", "ffffff")));
        entry.setTextColor(Color.parseColor("#" + Utils.prefs.getString("theme_wamod_conversation_entry_textcolor", "ffffff")));

        gallery.setColorFilter(Color.parseColor("#" + Utils.prefs.getString("theme_wamod_conversation_entry_btncolor", "ffffff")));
        audio.setColorFilter(Color.parseColor("#" + Utils.prefs.getString("theme_wamod_conversation_entry_btncolor", "ffffff")));
        location.setColorFilter(Color.parseColor("#" + Utils.prefs.getString("theme_wamod_conversation_entry_btncolor", "ffffff")));
        contact.setColorFilter(Color.parseColor("#" + Utils.prefs.getString("theme_wamod_conversation_entry_btncolor", "ffffff")));
        camera.setColorFilter(Color.parseColor("#" + Utils.prefs.getString("theme_wamod_conversation_entry_btncolor", "ffffff")));

        send.setColorFilter(Color.parseColor("#" + Utils.prefs.getString("theme_wamod_conversation_entry_sendbtncolor", "ffffff")));
        voicenote.setColorFilter(Color.parseColor("#" + Utils.prefs.getString("theme_wamod_conversation_entry_sendbtncolor", "ffffff")));

        emojibtn.setColorFilter(Color.parseColor("#" + Utils.prefs.getString("theme_wamod_conversation_entry_emojibtncolor", "ffffff")));


        final int originalPadding = entry.getPaddingRight();
        entry.setGravity(Gravity.LEFT | Gravity.CENTER);
        if (entry.getText().toString().trim().length() == 0) {
            entry.setGravity(Gravity.CENTER);
            entry.setPadding(entry.getPaddingLeft(), entry.getPaddingTop(), entry.getPaddingLeft(), entry.getPaddingBottom());
            //entry.setCursorVisible(false);
        }
        entry.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    entry.setGravity(Gravity.LEFT | Gravity.CENTER);
                    entry.setPadding(entry.getPaddingLeft(), entry.getPaddingTop(), originalPadding, entry.getPaddingBottom());
                    entry.setCursorVisible(true);
                } else {
                    entry.setGravity(Gravity.CENTER);
                    entry.setPadding(entry.getPaddingLeft(), entry.getPaddingTop(), entry.getPaddingLeft(), entry.getPaddingBottom());
                    //entry.setCursorVisible(false);
                }
            }
        });


        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Method to open Android gallery
                new Events.AttachmentsManager(activity).attachFromGallery();
            }
        });


        gallery.setOnLongClickListener(new dh(activity));
        audio.setOnClickListener(new y5(activity));
        location.setOnClickListener(new a5i(activity));
        contact.setOnClickListener(new b8(activity));
        camera.setOnClickListener(new av(activity, true));
    }
}
