package com.rjsj.pethospital.service.impl;

import com.rjsj.pethospital.entity.Case;
import com.rjsj.pethospital.entity.CaseType;
import com.rjsj.pethospital.entity.FullCase;
import com.rjsj.pethospital.entity.PartCase;
import com.rjsj.pethospital.repository.CaseRepository;
import com.rjsj.pethospital.repository.CaseTypeRepository;
import com.rjsj.pethospital.service.CaseService;
import com.rjsj.pethospital.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    CaseRepository caseRepository;

    @Autowired
    CaseTypeRepository caseTypeRepository;

    @Override
    public List<Case> findAll() {
        return caseRepository.findAll();
    }

    @Override
    public Map<String, List<String>> findAllByType() {
        List<CaseType> caseTypes = caseTypeRepository.findAll();
        Map map = new HashMap<String, List<String>>();
        for (CaseType caseType : caseTypes) {
            List<Case> cases = caseRepository.findAllByType(caseType.getType());
            List<String> list = new ArrayList<>();
            for (Case hospitalCase : cases)
                list.add(hospitalCase.getName1());
            map.put(caseType.getType(), list);
        }
        return map;
    }

    @Override
    public List<String> findAllByName(String name) {
        List<Case> cases = caseRepository.findAllByName1Contains(name);
        List<String> casesName = new ArrayList<>();
        for (Case hospitalCase : cases)
            casesName.add(hospitalCase.getName1());
        return casesName;
    }

    @Override
    public Optional<Case> findById(Long id) {
        return caseRepository.findById(id);
    }

    @Override
    public Case findByName(String name) {
        return caseRepository.findByName1(name);
    }

    private synchronized Case save(Case hospitalCase) {
        Case caseExist = caseRepository.findByName1(hospitalCase.getName1());
        if (caseExist != null) {
            hospitalCase.setId(caseExist.getId());
            if ((hospitalCase.getName2() == null || hospitalCase.getName2().equals("")) && caseExist.getName2() != null)
                hospitalCase.setName2(caseExist.getName2());
            if ((hospitalCase.getName3() == null || hospitalCase.getName3().equals("")) && caseExist.getName3() != null)
                hospitalCase.setName3(caseExist.getName3());
            if ((hospitalCase.getTreat2() == null || hospitalCase.getTreat2().equals("")) && caseExist.getTreat2() != null)
                hospitalCase.setTreat2(caseExist.getTreat2());
            if ((hospitalCase.getTreat3() == null || hospitalCase.getTreat3().equals("")) && caseExist.getTreat3() != null)
                hospitalCase.setTreat3(caseExist.getTreat3());
            if ((hospitalCase.getCheck2() == null || hospitalCase.getCheck2().equals("")) && caseExist.getCheck2() != null)
                hospitalCase.setCheck2(caseExist.getCheck2());
            if ((hospitalCase.getCheck3() == null || hospitalCase.getCheck3().equals("")) && caseExist.getCheck3() != null)
                hospitalCase.setCheck3(caseExist.getCheck3());
            if ((hospitalCase.getResult2() == null || hospitalCase.getResult2().equals("")) && caseExist.getResult2() != null)
                hospitalCase.setResult2(caseExist.getResult2());
            if ((hospitalCase.getResult3() == null || hospitalCase.getResult3().equals("")) && caseExist.getResult3() != null)
                hospitalCase.setResult3(caseExist.getResult3());
            if ((hospitalCase.getPlan2() == null || hospitalCase.getPlan2().equals("")) && caseExist.getPlan2() != null)
                hospitalCase.setPlan2(caseExist.getPlan2());
            if ((hospitalCase.getPlan3() == null || hospitalCase.getPlan3().equals("")) && caseExist.getPlan3() != null)
                hospitalCase.setPlan3(caseExist.getPlan3());
        }
        return caseRepository.save(hospitalCase);
    }

    @Override
    public Case save(HttpServletRequest request) {
        Case hospitalCase = new Case();
        hospitalCase.setType(request.getParameter("type"));
        hospitalCase.setName1(request.getParameter("name1"));
        hospitalCase.setTreat1(request.getParameter("treat1"));
        hospitalCase.setCheck1(request.getParameter("check1"));
        hospitalCase.setResult1(request.getParameter("result1"));
        hospitalCase.setPlan1(request.getParameter("plan1"));

        Case existCase = caseRepository.findByName1(hospitalCase.getName1());

        MultipartHttpServletRequest files = (MultipartHttpServletRequest) request;

        if (hospitalCase.getName2() != null && hospitalCase.getName2().equals("delete")) {
            FileUtil.removeFile(existCase.getName2());
            hospitalCase.setName2("");
        } else {
            hospitalCase.setName2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("name2")));
        }
        if (hospitalCase.getName3() != null && hospitalCase.getName3().equals("delete")) {
            FileUtil.removeFile(existCase.getName3());
            hospitalCase.setName3("");
        } else {
            hospitalCase.setName3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("name3")));
        }

        if (hospitalCase.getTreat2() != null && hospitalCase.getTreat2().equals("delete")) {
            FileUtil.removeFile(existCase.getTreat2());
            hospitalCase.setTreat2("");
        } else {
            hospitalCase.setTreat2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("treat2")));
        }
        if (hospitalCase.getTreat3() != null && hospitalCase.getTreat3().equals("delete")) {
            FileUtil.removeFile(existCase.getTreat3());
            hospitalCase.setTreat3("");
        } else {
            hospitalCase.setTreat3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("treat3")));
        }

        if (hospitalCase.getResult2() != null && hospitalCase.getResult2().equals("delete")) {
            FileUtil.removeFile(existCase.getResult2());
            hospitalCase.setResult2("");
        } else {
            hospitalCase.setResult2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("result2")));
        }
        if (hospitalCase.getResult3() != null && hospitalCase.getResult3().equals("delete")) {
            FileUtil.removeFile(existCase.getResult3());
            hospitalCase.setResult3("");
        } else {
            hospitalCase.setResult3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("result3")));
        }

        if (hospitalCase.getCheck2() != null && hospitalCase.getCheck2().equals("delete")) {
            FileUtil.removeFile(existCase.getCheck2());
            hospitalCase.setCheck2("");
        } else {
            hospitalCase.setCheck2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("check2")));
        }
        if (hospitalCase.getCheck3() != null && hospitalCase.getCheck3().equals("delete")) {
            FileUtil.removeFile(existCase.getCheck3());
            hospitalCase.setCheck3("");
        } else {
            hospitalCase.setCheck3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("check3")));
        }

        if (hospitalCase.getPlan2() != null && hospitalCase.getPlan2().equals("delete")) {
            FileUtil.removeFile(existCase.getPlan2());
            hospitalCase.setPlan2("");
        } else {
            hospitalCase.setPlan2(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("plan2")));
        }
        if (hospitalCase.getPlan3() != null && hospitalCase.getPlan3().equals("delete")) {
            FileUtil.removeFile(existCase.getPlan3());
            hospitalCase.setPlan3("");
        } else {
            hospitalCase.setPlan3(FileUtil.saveFile("case-" + hospitalCase.getName1() + "-1", files.getFile("plan3")));
        }

        return save(hospitalCase);
    }

    @Async
    public void addMark(Case saveCase) {
        saveCase.setName2(process(saveCase.getName2()));
        saveCase.setCheck2(process(saveCase.getCheck2()));
        saveCase.setTreat2(process(saveCase.getTreat2()));
        saveCase.setResult2(process(saveCase.getResult2()));
        saveCase.setPlan2(process(saveCase.getPlan2()));
        save(saveCase);
        saveCase.setName3(process(saveCase.getName3()));
        saveCase.setCheck3(process(saveCase.getCheck3()));
        saveCase.setTreat3(process(saveCase.getTreat3()));
        saveCase.setResult3(process(saveCase.getResult3()));
        saveCase.setPlan3(process(saveCase.getPlan3()));
        save(saveCase);
    }

    private String process(String fileName) {
        if (fileName == null || fileName.equals(""))
            return null;
        else if (fileName.contains("mark"))
            return fileName;
        File file = new File(FileUtil.fileParent, fileName);
        if (file.exists()) {
            try {
                if (FileUtil.isImage(file)) {
                    return FileUtil.addMark(file);
                } else if (FileUtil.isVideo(file)) {
                    return FileUtil.videoAddMark(file);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        caseRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        Case hospitalCase = caseRepository.findByName1(name);
        if (hospitalCase.getName2() != null && !hospitalCase.getName2().equals(""))
            FileUtil.removeFile(hospitalCase.getName2());
        if (hospitalCase.getName3() != null && !hospitalCase.getName3().equals(""))
            FileUtil.removeFile(hospitalCase.getName3());
        if (hospitalCase.getTreat2() != null && !hospitalCase.getTreat2().equals(""))
            FileUtil.removeFile(hospitalCase.getTreat2());
        if (hospitalCase.getTreat3() != null && !hospitalCase.getTreat3().equals(""))
            FileUtil.removeFile(hospitalCase.getTreat3());
        if (hospitalCase.getCheck2() != null && !hospitalCase.getCheck2().equals(""))
            FileUtil.removeFile(hospitalCase.getCheck2());
        if (hospitalCase.getCheck3() != null && !hospitalCase.getCheck3().equals(""))
            FileUtil.removeFile(hospitalCase.getCheck3());
        if (hospitalCase.getResult2() != null && !hospitalCase.getResult2().equals(""))
            FileUtil.removeFile(hospitalCase.getResult2());
        if (hospitalCase.getResult3() != null && !hospitalCase.getResult3().equals(""))
            FileUtil.removeFile(hospitalCase.getResult3());
        if (hospitalCase.getPlan2() != null && !hospitalCase.getPlan2().equals(""))
            FileUtil.removeFile(hospitalCase.getPlan2());
        if (hospitalCase.getPlan3() != null && !hospitalCase.getPlan3().equals(""))
            FileUtil.removeFile(hospitalCase.getPlan3());
        caseRepository.deleteByName1(name);
    }
}
