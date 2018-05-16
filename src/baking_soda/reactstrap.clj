(ns baking-soda.reactstrap)


(def reactstrap-tags
  '[Alert
    Badge
    Breadcrumb
    BreadcrumbItem
    Button
    ButtonDropdown
    ButtonGroup
    ButtonToolbar
    Card
    CardBlock
    CardBody
    CardColumns
    CardDeck
    CardFooter
    CardGroup
    CardHeader
    CardImg
    CardImgOverlay
    CardLink
    CardSubtitle
    CardText
    CardTitle
    Carousel
    CarouselCaption
    CarouselControl
    CarouselIndicators
    CarouselItem
    Col
    Collapse
    Container
    CustomInput
    Dropdown
    DropdownItem
    DropdownMenu
    DropdownToggle
    Fade
    Form
    FormFeedback
    FormGroup
    FormText
    Input
    InputGroup
    InputGroupAddon
    InputGroupButton
    InputGroupButtonDropdown
    InputGroupText
    Jumbotron
    Label
    ListGroup
    ListGroupItem
    ListGroupItemHeading
    ListGroupItemText
    Media
    Modal
    ModalBody
    ModalFooter
    ModalHeader
    Nav
    NavDropdown
    NavItem
    NavLink
    Navbar
    NavbarBrand
    NavbarToggler
    Pagination
    PaginationItem
    PaginationLink
    Popover
    PopoverBody
    PopoverContent
    PopoverHeader
    PopoverTitle
    PopperContent
    PopperTargetHelper
    Progress
    Row
    TabContent
    TabPane
    Table
    Tooltip
    UncontrolledAlert
    UncontrolledButtonDropdown
    UncontrolledCarousel
    UncontrolledDropdown
    UncontrolledNavDropdown
    UncontrolledTooltip
    ])


(defn create-reactstrap-component [tag]
  `(def ~tag (reagent.core/adapt-react-class
              (aget js/Reactstrap ~(name tag)))))


(defmacro export-reactstrap-components []
  `(do ~@(map create-reactstrap-component
              reactstrap-tags)))
