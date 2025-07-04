package com.isia.tfm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "APPLICATION_USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationUserEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "BIRTHDATE", nullable = false)
    private LocalDate birthdate;

    @Column(name = "GENDER", nullable = false)
    private String gender;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "PREFERENCE_1")
    private String preference1;

    @Column(name = "PREFERENCE_2")
    private String preference2;

    @Column(name = "PREFERENCE_3")
    private String preference3;

    @Column(name = "PREFERENCE_4")
    private String preference4;

    @Column(name = "PREFERENCE_5")
    private String preference5;

    @Column(name = "PREFERENCE_6")
    private String preference6;

    @Column(name = "PREFERENCE_7")
    private String preference7;

    @Column(name = "PREFERENCE_8")
    private String preference8;

    @Column(name = "PREFERENCE_9")
    private String preference9;

    @Column(name = "PREFERENCE_10")
    private String preference10;

    @Column(name = "PREFERENCE_11")
    private String preference11;

    @Column(name = "PREFERENCE_12")
    private String preference12;

    @Column(name = "PREFERENCE_13")
    private String preference13;

    @Column(name = "PREFERENCE_14")
    private String preference14;

    @Column(name = "PREFERENCE_15")
    private String preference15;

    @Column(name = "PREFERENCE_16")
    private String preference16;

    @Column(name = "PREFERENCE_17")
    private String preference17;

    @Column(name = "PREFERENCE_18")
    private String preference18;

    @Column(name = "PREFERENCE_19")
    private String preference19;

    @Column(name = "PREFERENCE_20")
    private String preference20;

    @Column(name = "PREFERENCE_21")
    private String preference21;

    @Column(name = "PREFERENCE_22")
    private String preference22;

    @Column(name = "PREFERENCE_23")
    private String preference23;

    @Column(name = "PREFERENCE_24")
    private String preference24;

    @Column(name = "PREFERENCE_25")
    private String preference25;

    @Column(name = "PREFERENCE_26")
    private String preference26;

    @Column(name = "PREFERENCE_27")
    private String preference27;

    @Column(name = "PREFERENCE_28")
    private String preference28;

    @Column(name = "PREFERENCE_29")
    private String preference29;

    @Column(name = "PREFERENCE_30")
    private String preference30;

    @Column(name = "PREFERENCE_31")
    private String preference31;

    @Column(name = "PREFERENCE_32")
    private String preference32;

    @Column(name = "PREFERENCE_33")
    private String preference33;

    @Column(name = "PREFERENCE_34")
    private String preference34;

    @Column(name = "PREFERENCE_35")
    private String preference35;

    @Column(name = "PREFERENCE_36")
    private String preference36;

    @Column(name = "PREFERENCE_37")
    private String preference37;

    @Column(name = "PREFERENCE_38")
    private String preference38;

    @Column(name = "PREFERENCE_39")
    private String preference39;

    @Column(name = "PREFERENCE_40")
    private String preference40;

    @Column(name = "PREFERENCE_41")
    private String preference41;

    @Column(name = "PREFERENCE_42")
    private String preference42;

    @Column(name = "PREFERENCE_43")
    private String preference43;

    @Column(name = "PREFERENCE_44")
    private String preference44;

    @Column(name = "PREFERENCE_45")
    private String preference45;

    @Column(name = "PREFERENCE_46")
    private String preference46;

    @Column(name = "PREFERENCE_47")
    private String preference47;

    @Column(name = "PREFERENCE_48")
    private String preference48;

    @Column(name = "PREFERENCE_49")
    private String preference49;

    @Column(name = "PREFERENCE_50")
    private String preference50;

    @Column(name = "PREFERENCE_51")
    private String preference51;

    @Column(name = "PREFERENCE_52")
    private String preference52;

    @Column(name = "PREFERENCE_53")
    private String preference53;

    @Column(name = "PREFERENCE_54")
    private String preference54;

    @Column(name = "PREFERENCE_55")
    private String preference55;

    @Column(name = "PREFERENCE_56")
    private String preference56;

    @Column(name = "PREFERENCE_57")
    private String preference57;

    @Column(name = "PREFERENCE_58")
    private String preference58;

    @Column(name = "PREFERENCE_59")
    private String preference59;

    @Column(name = "PREFERENCE_60")
    private String preference60;

    @Column(name = "PREFERENCE_61")
    private String preference61;

    @Column(name = "PREFERENCE_62")
    private String preference62;

    @Column(name = "PREFERENCE_63")
    private String preference63;

    @Column(name = "PREFERENCE_64")
    private String preference64;

    @Column(name = "PREFERENCE_65")
    private String preference65;

    @Column(name = "PREFERENCE_66")
    private String preference66;

    @Column(name = "PREFERENCE_67")
    private String preference67;

    @Column(name = "PREFERENCE_68")
    private String preference68;

    @Column(name = "PREFERENCE_69")
    private String preference69;

    @Column(name = "PREFERENCE_70")
    private String preference70;

    @Column(name = "PREFERENCE_71")
    private String preference71;

    @Column(name = "PREFERENCE_72")
    private String preference72;

    @Column(name = "PREFERENCE_73")
    private String preference73;

    @Column(name = "PREFERENCE_74")
    private String preference74;

    @Column(name = "PREFERENCE_75")
    private String preference75;

    @Column(name = "PREFERENCE_76")
    private String preference76;

    @Column(name = "PREFERENCE_77")
    private String preference77;

    @Column(name = "PREFERENCE_78")
    private String preference78;

    @Column(name = "PREFERENCE_79")
    private String preference79;

    @Column(name = "PREFERENCE_80")
    private String preference80;

    @Column(name = "PREFERENCE_81")
    private String preference81;

    @Column(name = "PREFERENCE_82")
    private String preference82;

    @Column(name = "PREFERENCE_83")
    private String preference83;

    @Column(name = "PREFERENCE_84")
    private String preference84;

    @Column(name = "PREFERENCE_85")
    private String preference85;

    @Column(name = "PREFERENCE_86")
    private String preference86;

    @Column(name = "PREFERENCE_87")
    private String preference87;

    @Column(name = "PREFERENCE_88")
    private String preference88;

    @Column(name = "PREFERENCE_89")
    private String preference89;

    @Column(name = "PREFERENCE_90")
    private String preference90;

    @Column(name = "PREFERENCE_91")
    private String preference91;

    @Column(name = "PREFERENCE_92")
    private String preference92;

    @Column(name = "PREFERENCE_93")
    private String preference93;

    @Column(name = "PREFERENCE_94")
    private String preference94;

    @Column(name = "PREFERENCE_95")
    private String preference95;

    @Column(name = "PREFERENCE_96")
    private String preference96;

    @Column(name = "PREFERENCE_97")
    private String preference97;

    @Column(name = "PREFERENCE_98")
    private String preference98;

    @Column(name = "PREFERENCE_99")
    private String preference99;

    @Column(name = "PREFERENCE_100")
    private String preference100;

    @Column(name = "PREFERENCE_101")
    private String preference101;

    @Column(name = "PREFERENCE_102")
    private String preference102;

    @Column(name = "PREFERENCE_103")
    private String preference103;

    @Column(name = "PREFERENCE_104")
    private String preference104;

    @Column(name = "PREFERENCE_105")
    private String preference105;

    @Column(name = "PREFERENCE_106")
    private String preference106;

    @Column(name = "PREFERENCE_107")
    private String preference107;

    @Column(name = "PREFERENCE_108")
    private String preference108;

    @Column(name = "PREFERENCE_109")
    private String preference109;

    @Column(name = "PREFERENCE_110")
    private String preference110;

    @Column(name = "PREFERENCE_111")
    private String preference111;

    @Column(name = "PREFERENCE_112")
    private String preference112;

    @Column(name = "PREFERENCE_113")
    private String preference113;

    @Column(name = "PREFERENCE_114")
    private String preference114;

    @Column(name = "PREFERENCE_115")
    private String preference115;

    @Column(name = "PREFERENCE_116")
    private String preference116;

    @Column(name = "PREFERENCE_117")
    private String preference117;

    @Column(name = "PREFERENCE_118")
    private String preference118;

    @Column(name = "PREFERENCE_119")
    private String preference119;

    @Column(name = "PREFERENCE_120")
    private String preference120;

    @Column(name = "PREFERENCE_121")
    private String preference121;

    @Column(name = "PREFERENCE_122")
    private String preference122;

    @Column(name = "PREFERENCE_123")
    private String preference123;

    @Column(name = "PREFERENCE_124")
    private String preference124;

    @Column(name = "PREFERENCE_125")
    private String preference125;

    @Column(name = "PREFERENCE_126")
    private String preference126;

    @Column(name = "PREFERENCE_127")
    private String preference127;

    @Column(name = "PREFERENCE_128")
    private String preference128;

    @Column(name = "PREFERENCE_129")
    private String preference129;

    @Column(name = "PREFERENCE_130")
    private String preference130;

    @Column(name = "PREFERENCE_131")
    private String preference131;

    @Column(name = "PREFERENCE_132")
    private String preference132;

    @Column(name = "PREFERENCE_133")
    private String preference133;

    @Column(name = "PREFERENCE_134")
    private String preference134;

    @Column(name = "PREFERENCE_135")
    private String preference135;

    @Column(name = "PREFERENCE_136")
    private String preference136;

    @Column(name = "PREFERENCE_137")
    private String preference137;

    @Column(name = "PREFERENCE_138")
    private String preference138;

    @Column(name = "PREFERENCE_139")
    private String preference139;

    @Column(name = "PREFERENCE_140")
    private String preference140;

    @Column(name = "PREFERENCE_141")
    private String preference141;

    @Column(name = "PREFERENCE_142")
    private String preference142;

    @Column(name = "PREFERENCE_143")
    private String preference143;

    @Column(name = "PREFERENCE_144")
    private String preference144;

    @Column(name = "PREFERENCE_145")
    private String preference145;

    @Column(name = "PREFERENCE_146")
    private String preference146;

    @Column(name = "PREFERENCE_147")
    private String preference147;

    @Column(name = "PREFERENCE_148")
    private String preference148;

    @Column(name = "PREFERENCE_149")
    private String preference149;

    @Column(name = "PREFERENCE_150")
    private String preference150;

    @Column(name = "PREFERENCE_151")
    private String preference151;

    @Column(name = "PREFERENCE_152")
    private String preference152;

    @Column(name = "PREFERENCE_153")
    private String preference153;

    @Column(name = "PREFERENCE_154")
    private String preference154;

    @Column(name = "PREFERENCE_155")
    private String preference155;

    @Column(name = "PREFERENCE_156")
    private String preference156;

    @Column(name = "PREFERENCE_157")
    private String preference157;

    @Column(name = "PREFERENCE_158")
    private String preference158;

    @Column(name = "PREFERENCE_159")
    private String preference159;

    @Column(name = "PREFERENCE_160")
    private String preference160;

    @Column(name = "PREFERENCE_161")
    private String preference161;

    @Column(name = "PREFERENCE_162")
    private String preference162;

    @Column(name = "PREFERENCE_163")
    private String preference163;

    @Column(name = "PREFERENCE_164")
    private String preference164;

    @Column(name = "PREFERENCE_165")
    private String preference165;

    @Column(name = "PREFERENCE_166")
    private String preference166;

    @Column(name = "PREFERENCE_167")
    private String preference167;

    @Column(name = "PREFERENCE_168")
    private String preference168;

    @Column(name = "PREFERENCE_169")
    private String preference169;

    @Column(name = "PREFERENCE_170")
    private String preference170;

    @Column(name = "PREFERENCE_171")
    private String preference171;

    @Column(name = "PREFERENCE_172")
    private String preference172;

    @Column(name = "PREFERENCE_173")
    private String preference173;

    @Column(name = "PREFERENCE_174")
    private String preference174;

    @Column(name = "PREFERENCE_175")
    private String preference175;

    @Column(name = "PREFERENCE_176")
    private String preference176;

    @Column(name = "PREFERENCE_177")
    private String preference177;

    @Column(name = "PREFERENCE_178")
    private String preference178;

    @Column(name = "PREFERENCE_179")
    private String preference179;

    @Column(name = "PREFERENCE_180")
    private String preference180;

    @Column(name = "PREFERENCE_181")
    private String preference181;

    @Column(name = "PREFERENCE_182")
    private String preference182;

    @Column(name = "PREFERENCE_183")
    private String preference183;

    @Column(name = "PREFERENCE_184")
    private String preference184;

    @Column(name = "PREFERENCE_185")
    private String preference185;

    @Column(name = "PREFERENCE_186")
    private String preference186;

    @Column(name = "PREFERENCE_187")
    private String preference187;

    @Column(name = "PREFERENCE_188")
    private String preference188;

    @Column(name = "PREFERENCE_189")
    private String preference189;

    @Column(name = "PREFERENCE_190")
    private String preference190;

    @Column(name = "PREFERENCE_191")
    private String preference191;

    @Column(name = "PREFERENCE_192")
    private String preference192;

    @Column(name = "PREFERENCE_193")
    private String preference193;

    @Column(name = "PREFERENCE_194")
    private String preference194;

    @Column(name = "PREFERENCE_195")
    private String preference195;

    @Column(name = "PREFERENCE_196")
    private String preference196;

    @Column(name = "PREFERENCE_197")
    private String preference197;

    @Column(name = "PREFERENCE_198")
    private String preference198;

    @Column(name = "PREFERENCE_199")
    private String preference199;

    @Column(name = "PREFERENCE_200")
    private String preference200;

    @Column(name = "CREATION_DATE", nullable = false)
    private LocalDateTime creationDate;

}
