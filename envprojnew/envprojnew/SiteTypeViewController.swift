//
//  SiteTypeViewController.swift
//  envprojnew
//
//  Created by Frances Lin on 8/13/17.
//  Copyright © 2017 Frances Lin. All rights reserved.
//

import Foundation
import UIKit

class SiteTypeViewController: UIViewController {
    
    @IBAction func nextViewButtonPressed2(_ sender: Any) {
        Properties.Land = false
        self.performSegue(withIdentifier: "LandOptionsSegue", sender: self)
    }
    @IBAction func nextViewButtonPressed(_ sender: Any) {
        Properties.Land = true
        self.performSegue(withIdentifier: "LandOptionsSegue", sender: self)
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    struct Properties{
        static var Land = Bool()
        
    }
    
    
}

