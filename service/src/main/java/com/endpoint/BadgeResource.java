package com.endpoint;

import com.service.BaseService;
import facade.api.IBadgeFacade;
import model.Badge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import view.BadgeView;

import java.io.*;
import java.util.Set;

@Controller
@RequestMapping("/api/badges")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class BadgeResource extends BaseService {

    @Autowired
    private IBadgeFacade badgeFacade;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Set<BadgeView> getBadges()throws Exception{
        return this.badgeFacade.getAll();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public BadgeView getBadge(@PathVariable("id")Long badgeId)throws Exception{
        return this.badgeFacade.getOne(badgeId);
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addBadge(@RequestBody Badge badge)throws Exception{
        this.badgeFacade.createBadge(badge);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteBadge(@PathVariable("id") Long badgeId)throws Exception{
        this.badgeFacade.deleteBadge(badgeId);
    }

    @RequestMapping(value = "/taskPlanUnAssignedBadges/{taskPlanId}",method = RequestMethod.GET)
    @ResponseBody
    public Set<BadgeView> getTaskPlanUnAssignedBadges(@PathVariable("taskPlanId")Long taskPlanId){
        return this.badgeFacade.getTaskPlanUnAssignedBadges(taskPlanId);
    }

    @RequestMapping(value = "/taskUnAssignedBadges/{taskId}",method = RequestMethod.GET)
    @ResponseBody
    public Set<BadgeView> getTaskUnAssignedBadges(@PathVariable("taskId")Long taskId){
        return this.badgeFacade.getTaskUnAssignedBadges(taskId);
    }
    @RequestMapping(value = "/{badgeId}",method = RequestMethod.PUT)
    @ResponseBody
    public void updateBadge(@RequestBody Badge badge)throws Exception{
        this.badgeFacade.updateOne(badge);
    }

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("image") MultipartFile multipartFile) throws Exception {

        // Get name of uploaded file.
        String fileName = multipartFile.getOriginalFilename();
        String fileDestination="C:/Work/apache-tomcat-7.0.67/images/badges/";
        File selectedFile = new File(fileDestination + fileName);

        // Path where the uploaded file will be stored.
        String path = fileDestination + fileName;
        multipartFile.transferTo(selectedFile);

        // This buffer will store the data read from 'uploadedFileRef'
        byte[] buffer = new byte[1000];

        // Now create the output file on the server.
        File outputFile = new File(path);

        processUpload(multipartFile, buffer, outputFile);
        return fileName;
    }


}
