'use strict';

johnGShultzApp.controller('ResumeController', ['$scope', 'resolvedResume', 'Resume',
    function ($scope, resolvedResume, Resume) {
        $scope.resumeData = [
            {
              name : 'Summary',
              info : 'As a professional I have enjoyed working with many impressive people who I have learned from. Over the past three years I have worked with both front end and backend web technologies.',
              header: 'section'
            }, {
              name : 'Experience',
              header: 'section'
            }, {
              title: 'Web Developer',
              name : 'The Lathe, March 2011 – Present (3 years 2 months) New York, NY',
              header: 'subsection',
              info: 'Designing and updating web, mobile web and mobile apps using the following technologies: Servers (ASP.NET, PHP, Tomcat, Java, Spring Framework, NODEJS), DBs (Oracle, MySQL, SQL Server, MongoDB), Mobile apps (iOS), web development (CSS3, HTML5, jQuery). Experience with responsive web design and fallback development for legacy (IE) browsers. Experience with UI/UX design process.'
            }, {
              title: 'Developer/DBA',
              name : 'Apparently, Inc March 2012 – June 2013 (1 year 4 months) New York, NY',
              header: 'subsection',
              info: 'Developing iOS Webkit modules using Jade, Stylus, client side Javascript and server side NodeJS Javascripting. Administrating and generating reports on MongoDB.'
            }, {
              title: 'Web Developer',
              name : 'Villas by Linda Smith September 2010 – March 2011 (7 months)',
              header: 'subsection',
              info: 'Website developing and content administration.'
            }, {
              title: 'Helpdesk Supervisor',
              name : 'The National Academies August 2004 – March 2010 (5 years 8 months) Washington, DC',
              header: 'subsection',
              info: 'Technolgoy support, training, reporting and management'
            }, {
              title: 'Internship',
              name : 'Jane Goodall Institute August 2003 – December 2003 (5 months)',
              header: 'subsection',
              info: 'Managing the membership access database. Reporting on Raiser\'s Edge Oracle database. Providing customer service to program members. Developing GIS component to system.'
            },  {
              name : 'Education',
              header: 'section'
            }, {
              title: '10gen (the MongoDB company)',
              name : 'M101 Mongo for Developers 2012 – 2012',
              header: 'subsection',
              info: 'Learned how to use MongoDB in the context of application development https://s3.amazonaws.com/edu-cert.10gen.com/downloads/e07a6da9252a4c6db970aa396b4ad71c/Certificate.pdf'
            }, {
              title: 'American University',
              name : 'Science Masters; Applied Sciences degree focused; Bachelors, Biotechnology 2004 – 2006',
              header: 'subsection',
              info: 'Simulations, Informatics & Analytics, Environmental Ethics, Bioinformatics, Molecular Genetics. Emphasis in group projects and collaboration.'
            },  {
              title: 'University of Vermont',
              name : 'BS, Biology 1996 – 2000',
              header: 'subsection'
            },  {
              name : 'Skills',
              header: 'section'
            },  {
              title: 'Web Development',
              info : 'AngularJS, NodeJS, MongoDB, Yeoman, Grunt, Bower, Foundation, Bootstrap, JQuery, CSS3',
              header: 'subsection'
            },  {
              title: 'Mobile App Development',
              info : 'iOS, Android, PhoneGap, CocoonJS',
              header: 'subsection'
            },  {
              title: 'Database',
              info : 'MongoDB, MySQL, Oracle',
              header: 'subsection'
            }
          ];
        $scope.resumes = resolvedResume;

        $scope.create = function () {
            Resume.save($scope.resume,
                function () {
                    $scope.resumes = Resume.query();
                    $('#saveResumeModal').modal('hide');
                    $scope.clear();
                });
        };

        $scope.update = function (id) {
            $scope.resume = Resume.get({id: id});
            $('#saveResumeModal').modal('show');
        };

        $scope.delete = function (id) {
            Resume.delete({id: id},
                function () {
                    $scope.resumes = Resume.query();
                });
        };

        $scope.clear = function () {
            $scope.resume = {id: "", sampleTextAttribute: "", sampleDateAttribute: ""};
        };
    }]);
