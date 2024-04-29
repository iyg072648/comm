package com.talk.comm.dto.validation;

public interface ValidationGroups {

    //빈칸, 글자수, 비밀번호 패턴 체크 3가지 항목
    public interface NotBlankGroup{};
    public interface SizeGroup{};
    public interface PatternCheckGroup{};
}
